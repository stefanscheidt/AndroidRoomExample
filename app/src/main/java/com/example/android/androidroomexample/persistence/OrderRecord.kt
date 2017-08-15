package com.example.android.androidroomexample.persistence

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "orders",
        foreignKeys = arrayOf(
                ForeignKey(entity = TourRecord::class,
                        parentColumns = arrayOf("code"),
                        childColumns = arrayOf("tour_code"),
                        onDelete = ForeignKey.CASCADE)))
data class OrderRecord @Ignore constructor(
        @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "code") var code: String,
        @ColumnInfo(name = "tour_code", index = true) var tourCode: String
) {

    // used by Room
    @Suppress("unused")
    constructor() : this(code = "UNKNOWN", tourCode = "UNKNOWN")

}