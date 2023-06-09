package com.example.catfoodtracker.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("food_entry_entity")
data class FoodEntryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val foodType: String,
    val isElisaChecked: Boolean,
    val isLuckyChecked: Boolean,
    val foodEntryTime: Long,
    val entryEntryDate: Long
)
