package com.ubaya.a160418062_utsgalangdana.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.ubaya.a160418062_utsgalangdana.model.GalangDana
import com.ubaya.a160418062_utsgalangdana.model.GalangDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val galangLD = MutableLiveData<List<GalangDana>>()
    val galangLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun refresh() {
        loadingLD.value = true
        galangLoadErrorLD.value = false
        launch {
            val db = Room.databaseBuilder(
                getApplication(),
                GalangDatabase::class.java, "newgalangdb").build()

            galangLD.value = db.galangDao().selectAllGalang()
        }
    }

    fun deleteGalang(galang: GalangDana) {
        launch {
            val db = Room.databaseBuilder(
                getApplication(),
                GalangDatabase::class.java, "newgalangdb").build()
            db.galangDao().deleteGalang(galang)

            galangLD.value = db.galangDao().selectAllGalang()
        }
    }



//    fun refresh() {
//        val galang1 =
//            GalangDana("1","Sumbangan ke anak yatim piatu","Diperlukan uang sebesar xxx untuk menyumbang ke sebuah panti asuhan di xxx","Nonie","https://assets-a1.kompasiana.com/statics/crawl/557f914e24a9d56c188b4567.jpeg")
//
//        val galang2 =
//            GalangDana("2","Galang dana Konser BTS","Uang akan digunakan untuk mengundang pihak BTS untuk melakukan konser pada tanggal xxx","Rich","https://cdn0-production-images-kly.akamaized.net/NvAoPNDx_gOVCCdyUXZDJarvkWw=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/3485446/original/011378800_1623921246-1.jpg")
//
//        val galang3 =
//            GalangDana("3","Galang dana untuk saya sekolah","Saya memerlukan uang untuk sekolah tolong bantu saya","Dinny","https://awsimages.detik.net.id/community/media/visual/2021/08/30/sekolah-tatap-muka-di-kudus-7_169.jpeg?w=700&q=90")
//
//        val galangList = arrayListOf<GalangDana>(galang1, galang2, galang3)
//
//        galangLD.value = galangList
//        galangLoadErrorLD.value = false
//        loadingLD.value = true
//    }

}