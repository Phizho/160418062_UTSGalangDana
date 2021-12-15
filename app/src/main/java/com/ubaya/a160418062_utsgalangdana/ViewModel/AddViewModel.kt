package com.ubaya.a160418062_utsgalangdana.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import com.ubaya.a160418062_utsgalangdana.Model.GalangDana
import com.ubaya.a160418062_utsgalangdana.Model.GalangDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class AddViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun addGalang(list:List<GalangDana>) {
        launch {
            val db = Room.databaseBuilder(
                getApplication(), GalangDatabase::class.java,
                "newgalangdb").build()
            db.galangDao().insertAll(*list.toTypedArray())
        }
    }
}