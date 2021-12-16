package com.ubaya.a160418062_utsgalangdana.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ubaya.a160418062_utsgalangdana.R
import com.ubaya.a160418062_utsgalangdana.databinding.FragmentDetailBinding
import com.ubaya.a160418062_utsgalangdana.util.loadImage
import com.ubaya.a160418062_utsgalangdana.viewModel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private var galUUID: Int = 0
    private lateinit var dataBinding:FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentDetailBinding>(inflater, R.layout.fragment_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null) {
            galUUID = DetailFragmentArgs.fromBundle(requireArguments()).galUUID
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