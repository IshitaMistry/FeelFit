package com.example.feelfit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "UserInfo")
class InfoEntityC(

    @PrimaryKey val email: String,
    @ColumnInfo(name = "gender") val gender: String?,
    @ColumnInfo(name = "height") val height: String?,
    @ColumnInfo(name = "weight") val weight: String?,
    @ColumnInfo(name = "age") val age: String?,
    @ColumnInfo(name = "bodyType") val body: String,
    @ColumnInfo(name = "bmi") val bmi: String

)


