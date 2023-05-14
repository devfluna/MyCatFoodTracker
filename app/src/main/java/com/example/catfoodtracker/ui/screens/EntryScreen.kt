package com.example.catfoodtracker.ui.screens

import android.app.TimePickerDialog
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catfoodtracker.data.FoodTimeFormatter
import com.example.catfoodtracker.ui.components.MultiStateToggle
import com.example.catfoodtracker.ui.theme.CatFoodTrackerTheme
import java.util.*

@Composable
fun EntryScreen(onEvent: (UIFoodEntry) -> Unit) {
    // Declaring and initializing a calendar
    val mCalendar = Calendar.getInstance()
    val mHour = mCalendar[Calendar.HOUR_OF_DAY]
    val mMinute = mCalendar[Calendar.MINUTE]

    // Value for storing time as a string
    val mTime = remember { mutableStateOf("00 : 00 am") }

    val now = Date().time
    mTime.value = FoodTimeFormatter.timeToSimpleHours(now)

    // Creating a TimePicker dialog
    val mTimePickerDialog = TimePickerDialog(
        LocalContext.current,
        { _, mHour: Int, mMinute: Int ->
            val lHour = if (mHour >= 12) mHour - 12 else mHour
            val meridian = if (mHour >= 12) "PM" else "AM"

            mTime.value = "$lHour:$mMinute $meridian"
        }, mHour, mMinute, false
    )

    Surface(modifier = Modifier.fillMaxSize()) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(text = mTime.value, fontSize = MaterialTheme.typography.h3.fontSize)

            Text(text = "OR")
            Button(onClick = { mTimePickerDialog.show() }) {
                Text(text = "PICK A TIME")
            }

            val isLucky = remember { mutableStateOf(false) }
            val isElisa = remember { mutableStateOf(false) }

//            SwitchAndName(name = "LUCKY", isChecked = isLucky.value, onClick = { isLucky.value = it })
//            SwitchAndName(name = "ELISA", isChecked = isElisa.value, onClick = { isElisa.value = it })

            Divider(modifier = Modifier.padding(horizontal = 32.dp))
            Spacer(modifier = Modifier.height(16.dp))

            var selectedCat = TrackerToggleStates.CATS[0]
            MultiStateToggle(states = TrackerToggleStates.CATS) {
                selectedCat = it
            }

            Spacer(modifier = Modifier.height(16.dp))
            Divider(modifier = Modifier.padding(horizontal = 32.dp))
            Spacer(modifier = Modifier.height(16.dp))

            var selectedFood = TrackerToggleStates.FOOD[0]
            MultiStateToggle(states = TrackerToggleStates.FOOD) {
                selectedFood = it
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { onEvent(
                UIFoodEntry(cat = selectedCat, food = selectedFood, timeFed = mTime.value, entryTime = now)
            ) }) {
                Text(text = "SAVE")
            }
        }
    }
}

data class UIFoodEntry(
    val cat: String,
    val food: String,
    val timeFed: String,
    val entryTime: Long
)

class TrackerToggleStates {
    companion object {
        val FOOD = listOf("Gluco", "Riñon", "Gluco Lata", "Riñon Lata")
        val CATS = listOf("LUCKY", "ELISA", "AMBOS")
    }
}

@Composable
fun SwitchAndName(name: String, isChecked: Boolean, onClick: (Boolean) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
    ) {
        Text(
            text = name,
            fontSize = MaterialTheme.typography.h4.fontSize,
            modifier = Modifier.align(alignment = Alignment.CenterStart)
        )
        Switch(
            checked = isChecked,
            onCheckedChange = { onClick(!isChecked) },
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun EntryScreenPreviewDark() {
    CatFoodTrackerTheme {
        EntryScreen(){}
    }
}

@Preview
@Composable
fun EntryScreenPreview() {
    CatFoodTrackerTheme {
        EntryScreen() {}
    }
}