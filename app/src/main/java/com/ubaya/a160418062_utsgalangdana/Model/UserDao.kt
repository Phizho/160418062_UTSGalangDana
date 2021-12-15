package com.ubaya.a160418062_utsgalangdana.Model

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg user:User)

    @Query("SELECT * FROM user WHERE name= :name")
    suspend fun selectUser(name:String): User

    @Delete
    suspend fun deleteUser(user:User)
}
