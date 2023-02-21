package com.example.feelfit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface UserInfoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(infoEntityC: InfoEntityC)


    @Query("UPDATE UserInfo SET bmi= :bmi ,bodyType= :bodyType,gender=:gender WHERE email = :email ")
    suspend fun Update( email: String,bmi :String,bodyType:String,gender:String)

    @Query("SELECT * FROM UserInfo WHERE email =:email")
    fun getAll(email: String): List<InfoEntityC>


}