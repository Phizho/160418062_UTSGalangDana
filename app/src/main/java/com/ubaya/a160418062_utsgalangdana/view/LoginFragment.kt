package com.ubaya.a160418062_utsgalangdana.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ubaya.a160418062_utsgalangdana.model.User
import com.ubaya.a160418062_utsgalangdana.R
import com.ubaya.a160418062_utsgalangdana.model.UserLogin.namaUser
import com.ubaya.a160418062_utsgalangdana.viewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    val prefs_name = "UserLogin"
    val nama = "key.nama"

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        btnRegister.setOnClickListener{
            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            Navigation.findNavController(it).navigate(action)
        }

        btnLog.setOnClickListener{
            val usr = User(editNama.text.toString(), editPassword.text.toString())
            viewModel.checkUser(usr)
            if (viewModel.LoginLD.value != null) {
                namaUser = usr.name.toString()
                val action = LoginFragmentDirections.actionLoginFragmentToItemHome()
                Navigation.findNavController(it).navigate(action)
            } else {
                Toast.makeText(view.context, "Username atau Password salah", Toast.LENGTH_LONG).show()
            }
        }
    }
}