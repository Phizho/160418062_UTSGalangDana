package com.ubaya.a160418062_utsgalangdana.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import com.ubaya.a160418062_utsgalangdana.model.User
import com.ubaya.a160418062_utsgalangdana.model.UserDatabase
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class UserViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun addUser(list:List<User>) {
        launch {
            val db = Room.databaseBuilder(
                getApplication(), UserDatabase::class.java,
                "newuserdb").build()
            db.userDao().insertAll(*list.toTypedArray())
        }
    }

    fun checkUser(user:User):Boolean {
        var usr = 1;
        launch {
            val db = Room.databaseBuilder(
                getApplication(), UserDatabase::class.java,
                "newuserdb"
            ).build()
            usr = db.userDao().selectUser(user.name.toString(), user.password.toString())
        }
        return usr != 0
    }
}