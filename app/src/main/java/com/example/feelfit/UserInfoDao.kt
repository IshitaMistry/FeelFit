package com.example.feelfit

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserInfoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(infoEntityC: InfoEntityC)

    @Query("UPDATE UserInfo SET bmi= :bmi ,bodyType= :bodyType,gender=:gender,weight=:weight WHERE email = :email ")
    suspend fun Update(  email: String,bmi :String,bodyType:String,gender:String,weight:String)

    @Query("SELECT * FROM UserInfo WHERE email =:email")
    fun getAll(email: String): List<InfoEntityC>


}