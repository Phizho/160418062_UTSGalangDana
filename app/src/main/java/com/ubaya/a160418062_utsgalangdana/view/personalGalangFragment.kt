package com.ubaya.a160418062_utsgalangdana.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubaya.a160418062_utsgalangdana.R
import com.ubaya.a160418062_utsgalangdana.viewModel.ListViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.refreshLayout
import kotlinx.android.synthetic.main.fragment_personal_galang.*

class personalGalangFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private val galangAdapter = GalangAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal_galang, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refreshPersonal()
        recGalang.layoutManager = LinearLayoutManager(context)
        recGalang.adapter = galangAdapter
        observeViewModel()

        refreshLayout.setOnRefreshListener {
            recGalang.visibility = View.GONE
            progressBar3.visibility = View.VISIBLE
            viewModel.refreshPersonal()
            refreshLayout.isRefreshing = false
        }
    }

    fun observeViewModel() {
        viewModel.galangLD.observe(viewLifecycleOwner, Observer {
            galangAdapter.updateGalangList(it)
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recGalang.visibility = View.VISIBLE
                progressBar3.visibility = View.GONE
            } else {
                recGalang.visibility = View.GONE
                progressBar3.visibility = View.VISIBLE
            }
        })
    }

}