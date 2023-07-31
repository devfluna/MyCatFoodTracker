package com.example.catfoodtracker.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entry: FoodEntryEntity)

    @Delete
    suspend fun delete(entry: FoodEntryEntity)

    @Query("SELECT * FROM food_entry_entity ORDER BY id DESC")
    fun getAllEntries(): Flow<List<FoodEntryEntity>>
}