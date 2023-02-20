package com.example.feelfit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "UserInfo")
class InfoEntityC(

    @PrimaryKey val email: String,
    @ColumnInfo(name = "gender") val gender: String?,
    @ColumnInfo(name = "height") var height: String?,
    @ColumnInfo(name = "weight") var weight: String?,
    @ColumnInfo(name = "age") var age: String?,
    @ColumnInfo(name = "bodyType") var body: String,
    @ColumnInfo(name = "bmi") var bmi: String

)


