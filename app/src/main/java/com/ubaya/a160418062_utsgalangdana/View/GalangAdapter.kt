package com.ubaya.a160418062_utsgalangdana.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.a160418062_utsgalangdana.Model.GalangDana
import com.ubaya.a160418062_utsgalangdana.R
import com.ubaya.a160418062_utsgalangdana.Util.loadImage
import kotlinx.android.synthetic.main.galang_dana_item.view.*

class GalangAdapter (val galangDanas:ArrayList<GalangDana>) :RecyclerView.Adapter<GalangAdapter.GalangViewHolder>() {
        class GalangViewHolder(var view: View) : RecyclerView.ViewHolder(view)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalangViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.galang_dana_item, parent, false)
            return GalangViewHolder(view)
        }

        override fun onBindViewHolder(holder: GalangViewHolder, position: Int) {
            holder.view.txtJudulGalang.text = galangDanas[position].nama
            //holder.view.txtDeskripsi.text = galangDanas[position].keterangan
            holder.view.imageView.loadImage(galangDanas[position].url, holder.view.proBar)


            holder.view.btnDetail.setOnClickListener {
                val action = MainFragmentDirections.actionDetailFragment(position)
                Navigation.findNavController(it).navigate(action)
            }
        }

        override fun getItemCount(): Int {
            return galangDanas.size
        }

        fun updateGalangList(newGalangDanas: List<GalangDana>) {
            galangDanas.clear()
            galangDanas.addAll(newGalangDanas)
            notifyDataSetChanged()
        }
    }