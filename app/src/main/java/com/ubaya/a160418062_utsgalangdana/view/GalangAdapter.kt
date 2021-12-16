package com.ubaya.a160418062_utsgalangdana.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.a160418062_utsgalangdana.model.GalangDana
import com.ubaya.a160418062_utsgalangdana.R
import com.ubaya.a160418062_utsgalangdana.util.loadImage
import com.ubaya.a160418062_utsgalangdana.databinding.GalangDanaItemBinding
import kotlinx.android.synthetic.main.fragment_main.*

class GalangAdapter (val galangDanas:ArrayList<GalangDana>) :RecyclerView.Adapter<GalangAdapter.GalangViewHolder>(), GalangDetailClick {

    class GalangViewHolder(var view:GalangDanaItemBinding) : RecyclerView.ViewHolder(view.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalangViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = DataBindingUtil.inflate<GalangDanaItemBinding>(inflater, R.layout.galang_dana_item, parent, false)
            return GalangViewHolder(view)
        }

        override fun onBindViewHolder(holder: GalangViewHolder, position: Int) {
            holder.view.detailListener = this
            holder.view.galang = galangDanas[position]
            holder.view.imageView.loadImage(galangDanas[position].url, holder.view.proBar)
        }

        override fun getItemCount(): Int {
            return galangDanas.size
        }

        fun updateGalangList(newGalangDanas: List<GalangDana>) {
            galangDanas.clear()
            galangDanas.addAll(newGalangDanas)
            notifyDataSetChanged()
        }

    override fun onGalangDetailClick(v: View) {
        val uuid = v.tag.toString().toInt()
        val action = MainFragmentDirections.actionDetailFragment(uuid)

        Navigation.findNavController(v).navigate(action)
    }
}