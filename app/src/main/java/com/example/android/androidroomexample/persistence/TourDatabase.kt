package com.example.android.androidroomexample.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(OrderRecord::class, TourRecord::class), version = 1, exportSchema = false)
abstract class TourDatabase : RoomDatabase() {

    abstract fun tourDao(): TourDao

}