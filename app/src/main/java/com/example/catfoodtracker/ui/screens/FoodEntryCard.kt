package com.example.catfoodtracker.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catfoodtracker.data.database.FoodEntryEntity
import com.example.catfoodtracker.ui.theme.CatFoodTrackerTheme

@Composable
fun FoodEntryCard(foodEntry: FoodEntryEntity) {
    Card(elevation = 2.dp, shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(bottom = 4.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth(1f)) {
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
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.wrapContentWidth(align = Alignment.Start)) {
        Text(text = foodEntry, modifier = Modifier.padding(horizontal = 8.dp), textAlign = TextAlign.Start)
    }
}

@Composable
fun GivenCatIndicator(isLucky: Boolean, isElisa: Boolean) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End, modifier = Modifier.wrapContentWidth()) {
        if (isLucky) Image(painter = painterResource(id = com.example.catfoodtracker.R.drawable.paw_lucky), contentDescription = null, modifier = Modifier.size(24.dp))
        if (isElisa) Image(painter = painterResource(id = com.example.catfoodtracker.R.drawable.paw_elisa), contentDescription = null, modifier = Modifier.size(24.dp))
    }
}

@Preview
@Composable
fun FoodEntryCardPreview() {
    CatFoodTrackerTheme() {
        FoodEntryCard(foodEntry = FoodEntryEntity(foodName = "", foodType = "", isLuckyChecked = false, isElisaChecked = false, foodEntryTime = "", entryEntryDate = 1L))
    }
}