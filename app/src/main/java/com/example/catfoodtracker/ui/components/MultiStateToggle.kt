package com.example.catfoodtracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catfoodtracker.ui.theme.CatFoodTrackerTheme

@Composable
fun MultiStateToggle(states: List<String>, callback: (String) -> Unit) {

    var selectedOption by remember { mutableStateOf(states[0]) }
    val onSelectionChange = { text: String -> selectedOption = text }

    Surface(
        shape = RoundedCornerShape(24.dp),
        elevation = 2.dp,
        modifier = Modifier.wrapContentWidth()
    ) {
        Row(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(24.dp))
                .background(MaterialTheme.colors.surface)
        ) {
            states.forEach { text ->
                Text(
                    text = text,
                    color =  MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .clip(RoundedCornerShape(24.dp))
                        .clickable {
                            onSelectionChange(text)
                            callback(text)
                        }
                        .background(
                            if (text == selectedOption) MaterialTheme.colors.primary
                            else MaterialTheme.colors.surface
                        )
                        .padding(vertical = 12.dp, horizontal = 16.dp)
                )
            }
        }

    }
}

@Preview
@Composable
fun MultiStateTogglePreview() {
    val states = listOf("Gluco", "Riñon", "Gluco Lata", "Riñon Lata")
    CatFoodTrackerTheme {
        MultiStateToggle(states){}
    }

}