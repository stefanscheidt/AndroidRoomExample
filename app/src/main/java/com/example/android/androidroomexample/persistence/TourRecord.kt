package com.example.android.androidroomexample.persistence

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "tours")
data class TourRecord @Ignore constructor(
        @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "code") var code: String
){

    // used by Room
    @Suppress("unused")
    constructor(): this(code = "UNKNOWN")

}