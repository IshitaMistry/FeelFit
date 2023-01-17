package com.example.feelfit

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserInfoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(infoEntityC: InfoEntityC)

    @Query("UPDATE UserInfo SET bmi= :bmi ,bodyType= :bodyType WHERE email = email ")
    suspend fun Update(bmi :String,bodyType:String)

    @Query("SELECT *FROM UserInfo ")
    fun getAll(): List<InfoEntityC>


}