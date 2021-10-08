package com.ubaya.a160418062_utsgalangdana.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.a160418062_utsgalangdana.Model.GalangDana

class ListViewModel: ViewModel() {
    val galangLD = MutableLiveData<List<GalangDana>>()
    val galangLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh() {
        val galang1 =
            GalangDana("1","Sumbangan ke anak yatim piatu","Diperlukan uang sebesar xxx untuk menyumbang ke sebuah panti asuhan di xxx","Nonie","http://dummyimage.com/75x100.jpg/cc0000/ffffff")

        val galang2 =
            GalangDana("2","Galang dana Konser BTS","Uang akan digunakan untuk mengundang pihak BTS untuk melakukan konser pada tanggal xxx","Rich","http://dummyimage.com/75x100.jpg/5fa2dd/ffffff")

        val galang3 =
            GalangDana("3","Galang dana untuk saya sekolah","Saya memerlukan uang untuk sekolah tolong bantu saya","Dinny","http://dummyimage.com/75x100.jpg/5fa2dd/ffffff1")

        val galangList = arrayListOf<GalangDana>(galang1, galang2, galang3)

        galangLD.value = galangList
        galangLoadErrorLD.value = false
        loadingLD.value = true
    }

}