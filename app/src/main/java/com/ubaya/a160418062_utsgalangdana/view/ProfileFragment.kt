package com.ubaya.a160418062_utsgalangdana.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ubaya.a160418062_utsgalangdana.R
import com.ubaya.a160418062_utsgalangdana.model.UserLogin.namaUser
import com.ubaya.a160418062_utsgalangdana.viewModel.UserViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        if (namaUser != "") {
            btnLogin.visibility = View.GONE
            //imgProfile.visibility = View.VISIBLE
            btnListGalang.visibility = View.VISIBLE
            btnLogOut.visibility = View.VISIBLE
            txtName.visibility = View.VISIBLE
            txtName.text = namaUser

            btnListGalang.setOnClickListener{
                val action = ProfileFragmentDirections.actionItemProfileToPersonalGalangFragment()
                Navigation.findNavController(it).navigate(action)
            }

            btnLogOut.setOnClickListener{
                //belom refresh setiap di klik
                namaUser = ""
            }
        } else {
            btnLogin.visibility = View.VISIBLE
            btnListGalang.visibility = View.GONE
            btnLogOut.visibility = View.GONE
            //imgProfile.visibility = View.GONE
            txtName.visibility = View.GONE

            btnLogin.setOnClickListener{
                val action = ProfileFragmentDirections.actionItemProfileToLoginFragment()
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

}