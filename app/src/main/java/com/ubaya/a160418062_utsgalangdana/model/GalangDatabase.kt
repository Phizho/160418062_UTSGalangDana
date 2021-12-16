package com.ubaya.a160418062_utsgalangdana.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(GalangDana::class), version =  1)
abstract class GalangDatabase: RoomDatabase() {

    abstract fun galangDao(): GalangDao

    companion object {
        @Volatile private var instance: GalangDatabase ?= null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                GalangDatabase::class.java,
                "newgalangdb").build()

        operator fun invoke(context:Context) {
            if(instance!=null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }

    }
}