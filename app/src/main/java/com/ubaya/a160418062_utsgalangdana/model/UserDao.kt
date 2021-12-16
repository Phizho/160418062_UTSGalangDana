package com.ubaya.a160418062_utsgalangdana.model

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg user:User)

    @Query("SELECT EXISTS(SELECT * FROM user WHERE name= :name AND password= :password)")
    suspend fun selectUser(name:String, password:String): Int

    @Delete
    suspend fun deleteUser(user:User)
}
