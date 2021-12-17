package com.ubaya.a160418062_utsgalangdana.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ubaya.a160418062_utsgalangdana.R
import com.ubaya.a160418062_utsgalangdana.databinding.FragmentDetailBinding
import com.ubaya.a160418062_utsgalangdana.databinding.FragmentEditBinding
import com.ubaya.a160418062_utsgalangdana.viewModel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*

class EditFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private var galUUID: Int = 0
    private lateinit var dataBinding: FragmentEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_edit, container, false)
        dataBinding = DataBindingUtil.inflate<FragmentEditBinding>(inflater, R.layout.fragment_edit, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            galUUID = EditFragmentArgs.fromBundle(requireArguments()).editUUID
        }
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(galUUID)
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.galangLD.observe(viewLifecycleOwner, Observer {
            dataBinding.galang = it
        })
    }
}