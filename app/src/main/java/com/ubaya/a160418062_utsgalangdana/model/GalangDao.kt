package com.ubaya.a160418062_utsgalangdana.model

import androidx.room.*

@Dao
interface GalangDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg galangDana:GalangDana)

    @Query("SELECT * FROM galangdana")
    suspend fun selectAllGalang(): List<GalangDana>

    @Query("SELECT * FROM galangDana WHERE uuid= :id")
    suspend fun selectGalang(id:Int): GalangDana

    @Query("SELECT * FROM galangDana WHERE pemilik= :pemilik")
    suspend fun selectAllPersonalGalang(pemilik:String): List<GalangDana>

    @Delete
    suspend fun deleteGalang(galang:GalangDana)
}
