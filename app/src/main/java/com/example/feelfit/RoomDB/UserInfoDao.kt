package com.example.feelfit.RoomDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserInfoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(infoEntityC: InfoEntityC)

    @Query("UPDATE UserInfo SET bmi= :bmi ,bodyType= :bodyType,gender=:gender, age=:age,height=:height,weight=:weight WHERE email = :email ")
    suspend fun Update( email: String,bmi :String,bodyType:String,gender:String,age:String,height:String,weight:String)

    @Query("SELECT * FROM UserInfo WHERE email =:email")
    fun getAll(email: String): List<InfoEntityC>

}