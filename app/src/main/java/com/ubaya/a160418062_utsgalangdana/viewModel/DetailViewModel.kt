package com.ubaya.a160418062_utsgalangdana.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.ubaya.a160418062_utsgalangdana.model.GalangDana
import com.ubaya.a160418062_utsgalangdana.model.GalangDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailViewModel (application: Application): AndroidViewModel(application), CoroutineScope {
   var galangLD = MutableLiveData<GalangDana>()

    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun fetch(galUUID : Int) {
        launch {
            val db = Room.databaseBuilder(
                getApplication(), GalangDatabase::class.java,
                "newgalangdb").build()
            galangLD.value = db.galangDao().selectGalang(galUUID)
        }
    }
}