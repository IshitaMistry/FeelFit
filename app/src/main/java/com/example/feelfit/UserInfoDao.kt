package com.example.feelfit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface UserInfoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(infoEntityC: InfoEntityC)

    @Query("UPDATE UserInfo SET bmi= :bmi ,bodyType= :bodyType WHERE email = :email ")
    suspend fun Update(  email: String,bmi :String,bodyType:String)

    @Query("SELECT * FROM UserInfo WHERE email =:email")
    fun getAll(email: String): List<InfoEntityC>


}