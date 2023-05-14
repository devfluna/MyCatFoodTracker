package com.example.catfoodtracker.di

import android.app.Application
import androidx.room.Room
import com.example.catfoodtracker.data.database.TrackerDao
import com.example.catfoodtracker.data.database.TrackerDatabase
import com.example.catfoodtracker.ui.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesDatabase(app: Application): TrackerDatabase {
        return Room.databaseBuilder(
            app,
            TrackerDatabase::class.java,
            "food_tracker_db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesTrackerDao(database: TrackerDatabase): TrackerDao = database.trackerDao()

    @Provides
    @Singleton
    fun providesMainViewModel(trackerDao: TrackerDao): MainViewModel {
        return MainViewModel(trackerDao)
    }
}