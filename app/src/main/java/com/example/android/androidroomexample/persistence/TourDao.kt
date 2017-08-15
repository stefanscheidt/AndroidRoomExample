package com.example.android.androidroomexample.persistence

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert

@Dao
interface TourDao {

    @Insert
    fun insertTourRecord(record: TourRecord)

    @Insert
    fun insertOrderRecord(orderRecord: OrderRecord)

}