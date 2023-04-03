package com.example.feelfit

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.feelfit.NonVegFDietAdapter.*
import com.example.feelfit.databinding.ItemDietnonvegLayoutBinding
import com.google.firebase.database.core.view.View

class NonVegFDietAdapter(private val NonVegDietList: List<NonVegF>) :
    RecyclerView.Adapter<NonVegViewHolder>() {

   inner class NonVegViewHolder(private val binding: ItemDietnonvegLayoutBinding):RecyclerView.ViewHolder(binding.root) {
       fun bind(nonVegF: NonVegF) {
           binding.nonVdietPtext1.text=nonVegF.text
           Glide.with(binding.root)
               .load(nonVegF.imageurl)
               .into(binding.imgdietnonvef)

       }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NonVegViewHolder {
        val binding = ItemDietnonvegLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NonVegViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NonVegViewHolder, position: Int) {
        holder.bind(NonVegDietList[position])
    }

    override fun getItemCount(): Int {
        return NonVegDietList.size
    }
}