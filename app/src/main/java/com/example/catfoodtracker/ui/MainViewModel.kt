package com.example.catfoodtracker.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catfoodtracker.data.database.FoodEntryEntity
import com.example.catfoodtracker.data.database.TrackerDao
import com.example.catfoodtracker.ui.screens.UIFoodEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val trackerDao: TrackerDao) : ViewModel() {

    val foodEntries: Flow<List<FoodEntryEntity>> = trackerDao.getAllEntries()

    fun saveFoodEntry(entry: UIFoodEntry){
        viewModelScope.launch {
            val fooEntry = UIFoodEntryToDataFoodEntryMapper().map(entry)
            trackerDao.insert(fooEntry)
        }
    }
}

class UIFoodEntryToDataFoodEntryMapper {
    fun map(entry: UIFoodEntry): FoodEntryEntity {

        val isElisaChecked = entry.cat == "ELISA" || entry.cat == "AMBOS"
        val isLuckyChecked = entry.cat == "LUCKY" || entry.cat == "AMBOS"
        return FoodEntryEntity(
            foodName = entry.food,
            foodType = "DELETE",
            isElisaChecked = isElisaChecked,
            isLuckyChecked = isLuckyChecked,
            foodEntryTime = entry.timeFed,
            entryEntryDate = entry.entryTime
        )
    }
}