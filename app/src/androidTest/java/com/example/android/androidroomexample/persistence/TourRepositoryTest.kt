package com.example.android.androidroomexample.persistence

import android.arch.persistence.room.Room
import android.database.sqlite.SQLiteConstraintException
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.example.android.androidroomexample.model.Order
import com.example.android.androidroomexample.model.Tour
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TourRepositoryTest {

    lateinit var tourDatabase: TourDatabase
    lateinit var tourDao: TourDao
    lateinit var tourRepository: TourRepository

    @Before
    fun setUp() {
        tourDatabase = Room
                .inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), TourDatabase::class.java)
                .allowMainThreadQueries()
                .build()
        tourDao = tourDatabase.tourDao()
        tourRepository = TourRepository(database = tourDatabase, tourDao = tourDao)
    }

    @After
    fun tearDown() {
        tourDatabase.close()
    }

    @Test(expected = SQLiteConstraintException::class)
    fun insertInvalidTour() {
        tourRepository.insertTour(Tour("tour-1", arrayListOf(Order("order-1"), Order("order-1"))))
    }
}