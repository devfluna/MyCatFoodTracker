package com.example.catfoodtracker.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catfoodtracker.R
import com.example.catfoodtracker.data.database.FoodEntryEntity
import com.example.catfoodtracker.ui.theme.CatFoodTrackerTheme

@Composable
fun MainScreen(foodEntryList: List<FoodEntryEntity>, onNewEntryClick: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize()) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            LazyColumn(
                contentPadding = PaddingValues(vertical = 8.dp, horizontal = 8.dp),
                modifier = Modifier.weight(weight = 1f, fill = false)
            ) {
                items(foodEntryList.size) {
                    FoodEntryCard(foodEntry = foodEntryList[it])
                }
            }

            Button(onClick = onNewEntryClick) {
                Text(text = stringResource(id = R.string.new_entry))
            }

        }
    }
}

val dudeList = listOf(
    FoodEntryEntity(
        foodName = "INSULINA1",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
    FoodEntryEntity(
        foodName = "INSULINA2",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
    FoodEntryEntity(
        foodName = "INSULINA3",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
    FoodEntryEntity(
        foodName = "INSULINA4",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
    FoodEntryEntity(
        foodName = "INSULINA5",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
    FoodEntryEntity(
        foodName = "INSULINA",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
    FoodEntryEntity(
        foodName = "INSULINA",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
    FoodEntryEntity(
        foodName = "INSULINA",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
    FoodEntryEntity(
        foodName = "INSULINA",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
    FoodEntryEntity(
        foodName = "INSULINA",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
    FoodEntryEntity(
        foodName = "INSULINA",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
    FoodEntryEntity(
        foodName = "INSULINA",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
    FoodEntryEntity(
        foodName = "INSULINA",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
    FoodEntryEntity(
        foodName = "INSULINA",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
    FoodEntryEntity(
        foodName = "INSULINA",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
    FoodEntryEntity(
        foodName = "INSULINA",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
    FoodEntryEntity(
        foodName = "INSULINA",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
    FoodEntryEntity(
        foodName = "INSULINA",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
    FoodEntryEntity(
        foodName = "INSULINA",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
    FoodEntryEntity(
        foodName = "INSULINA",
        foodType = "LATA",
        isElisaChecked = true,
        isLuckyChecked = true,
        entryEntryDate = 1L,
        foodEntryTime = "2L"
    ),
)

@Preview
@Composable
fun MainScreenPreview() {
    CatFoodTrackerTheme() {
        MainScreen(foodEntryList = dudeList) { }
    }
}