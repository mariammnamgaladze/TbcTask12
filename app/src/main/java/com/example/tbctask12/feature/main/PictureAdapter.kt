package com.example.tbctask12.feature.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tbctask12.databinding.PicturesLayoutBinding
import com.example.tbctask12.feature.data.PictureModel

class PictureAdapter(val list: MutableList<PictureModel>):RecyclerView.Adapter<PictureAdapter.ViewHolder>() {

    var onItemClickListener: ((PictureModel) -> Unit)? = null


    fun updateList(newList: List<PictureModel>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(var binding:PicturesLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bindUi(item:PictureModel){
         binding.imageView2.setImageResource(item.imageRes)

            binding.imageView2.setOnClickListener{
                onItemClickListener?.invoke(item)
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureAdapter.ViewHolder {
        return ViewHolder(
            PicturesLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: PictureAdapter.ViewHolder, position: Int) {
            holder.bindUi(list[position])
    }

    override fun getItemCount() = list.size
}