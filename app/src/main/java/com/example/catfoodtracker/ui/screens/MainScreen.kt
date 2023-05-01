package com.example.catfoodtracker.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import com.example.catfoodtracker.data.database.FoodEntryEntity
import java.util.Random

@Composable
fun MainScreen(entryList: List<FoodEntryEntity>, onEvent: () -> Unit) {
    var counterText by remember { mutableStateOf("") }

    MainScreenStateless(counterText) { counterText = it }

}

@Composable
fun MainScreenStateless(name: String, onEvent: (String) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = name)

        Text(text = "The list IS $name" )

        Button(onClick = { onEvent(" ${Random().nextInt()} ") } ) {
            Text(text = "DO SOMETHING")
        }
    }
}