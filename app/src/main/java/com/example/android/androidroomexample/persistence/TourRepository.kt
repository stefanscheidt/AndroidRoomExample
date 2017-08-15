package com.example.android.androidroomexample.persistence

import com.example.android.androidroomexample.model.Tour

class TourRepository(private val database: TourDatabase, private val tourDao: TourDao) {

    @Synchronized
    fun insertTour(tour: Tour) {
        database.beginTransaction()
        try {
            tourDao.insertTourRecord(TourRecord(tour.code))
            tour.orders.forEach {
                tourDao.insertOrderRecord(OrderRecord(code = it.code, tourCode = tour.code))
            }
            database.setTransactionSuccessful()
        } finally {
            database.endTransaction()
        }
    }

}