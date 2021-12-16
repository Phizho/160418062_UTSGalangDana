package com.ubaya.a160418062_utsgalangdana.model

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg user:User)

    @Query("SELECT * FROM user WHERE name= :name and password= :password")
    suspend fun selectUser(name:String, password:String): User

    @Delete
    suspend fun deleteUser(user:User)
}
