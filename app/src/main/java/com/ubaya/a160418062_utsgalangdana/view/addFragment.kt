package com.ubaya.a160418062_utsgalangdana.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ubaya.a160418062_utsgalangdana.model.GalangDana
import com.ubaya.a160418062_utsgalangdana.R
import com.ubaya.a160418062_utsgalangdana.viewModel.AddViewModel
import kotlinx.android.synthetic.main.fragment_add.*

class addFragment : Fragment() {
    private lateinit var viewModel: AddViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProvider(this).get(AddViewModel::class.java)


        btnAdd.setOnClickListener {
            var galang = GalangDana(editNamaGalangDana.text.toString(), editDeskripsiGalang.text.toString(),"1",editUrlGalang.text.toString())

            val list = listOf(galang)
            viewModel.addGalang(list)
            Toast.makeText(view.context, "Data added", Toast.LENGTH_LONG).show()
            Navigation.findNavController(it).popBackStack()
        }
    }
}