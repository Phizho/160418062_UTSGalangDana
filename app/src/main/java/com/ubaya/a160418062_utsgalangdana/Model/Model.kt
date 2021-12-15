package com.ubaya.a160418062_utsgalangdana.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GalangDana(
    @ColumnInfo(name="nama")
    var nama:String,
    @ColumnInfo(name="keterangan")
    var keterangan:String,
    @ColumnInfo(name="pemilik")
    var pemilik:String,
    @ColumnInfo(name="url")
    var url:String
) {
    @PrimaryKey(autoGenerate = true)
    var uuid:Int = 0
}

@Entity
data class User(
    @ColumnInfo(name="name")
    val name:String?,
    @ColumnInfo(name="password")
    val password:String?
) {
    @PrimaryKey(autoGenerate = true)
    var uuid:Int = 0
}