package com.example.catfoodtracker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catfoodtracker.data.database.FoodEntryEntity
import com.example.catfoodtracker.ui.theme.CatFoodTrackerTheme

@Composable
fun FoodEntryCard(foodEntry: FoodEntryEntity) {
    Card(elevation = 2.dp, shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(bottom = 4.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth(1f)) {
            FoodType(foodEntry.foodName)
            TypeAndDate(foodEntry.foodEntryTime)
            GivenCatIndicator(isLucky = foodEntry.isLuckyChecked, isElisa = foodEntry.isElisaChecked)
        }
    }
    
}

@Composable
fun FoodType(foodName: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.wrapContentWidth()) {
        Text(text = foodName, modifier = Modifier.padding(horizontal = 8.dp))
    }
}

@Composable
fun TypeAndDate(foodEntry: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.wrapContentWidth()) {
        Text(text = foodEntry, modifier = Modifier.padding(horizontal = 8.dp))
    }
}

@Composable
fun GivenCatIndicator(isLucky: Boolean, isElisa: Boolean) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.wrapContentWidth()) {
        if (isLucky) Text(text = "Elisa", modifier = Modifier.padding(horizontal = 8.dp))
        if (isElisa) Text(text = "Lucky", modifier = Modifier.padding(horizontal = 8.dp))
    }
}



@Preview
@Composable
fun FoodEntryCardPreview() {
    CatFoodTrackerTheme() {
        FoodEntryCard(foodEntry = FoodEntryEntity(foodName = "", foodType = "", isLuckyChecked = false, isElisaChecked = false, foodEntryTime = "", entryEntryDate = 1L))
    }
}