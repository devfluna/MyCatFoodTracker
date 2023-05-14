package com.example.catfoodtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.catfoodtracker.ui.MainViewModel
import com.example.catfoodtracker.ui.screens.EntryScreen
import com.example.catfoodtracker.ui.screens.MainScreen
import com.example.catfoodtracker.ui.screens.dudeList
import com.example.catfoodtracker.ui.theme.CatFoodTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatFoodTrackerTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "HOME") {
                    composable("HOME") {
                        val viewModel: MainViewModel = hiltViewModel()

                        val foodList by viewModel.foodEntries.collectAsState(initial = emptyList())
                        MainScreen(foodEntryList = foodList) {
                            navController.navigate("ENTRY")
                        }
                    }

                    composable("ENTRY") {
                        val viewModel: MainViewModel = hiltViewModel()
                        EntryScreen {
                            viewModel.saveFoodEntry(it)
                            navController.navigate("HOME")
                        }
                    }
                }
            }
        }
    }
}