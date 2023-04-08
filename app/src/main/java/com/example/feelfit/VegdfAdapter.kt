package com.example.feelfit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.feelfit.databinding.ItemVegdietFragmentBinding
import com.firebase.ui.database.FirebaseRecyclerOptions

class VegdfAdapter(private val VegDietList:List <VegDModel>):
    RecyclerView.Adapter<VegdfAdapter.VegViewHolder>() {


   inner class VegViewHolder(private val binding: ItemVegdietFragmentBinding):RecyclerView.ViewHolder(binding.root) {
       fun bind(vegDModel: VegDModel) {
           binding.vegdietAmount.text=vegDModel.toString()
           binding.vegdietFname.text=vegDModel.toString()
           binding.calorievegd.text=vegDModel.toString()
           Glide.with(binding.root)
               .load(vegDModel.img)
               .into(binding.imgdietvegf)
       }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VegViewHolder {
        val binding = ItemVegdietFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VegViewHolder (binding)
    }

    override fun onBindViewHolder(holder: VegViewHolder, position: Int) {
        holder.bind(VegDietList[position])
    }

    override fun getItemCount(): Int {
        return VegDietList.size
    }
}