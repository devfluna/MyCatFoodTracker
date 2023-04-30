package com.example.catfoodtracker.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FoodEntryEntity::class], version = 1, exportSchema = false)
abstract class TrackerDatabase: RoomDatabase() {
    abstract fun trackerDao(): TrackerDao
}