package com.example.feelfit.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.feelfit.R
import com.example.feelfit.itemview3

class customAdapter3(private val mList3: List<itemview3>, val listner: MyClickListener):
        RecyclerView.Adapter<customAdapter3.ViewHolder>()
{

    inner class ViewHolder(Itemview3:View):RecyclerView.ViewHolder(Itemview3)
    {
        val imageView1: ImageView=Itemview3.findViewById(R.id.exercise_one_normal)
        val textView2: TextView=Itemview3.findViewById(R.id.text2_Exercise_normal)
        val imageShow3: ImageView=Itemview3.findViewById(R.id.img2_normal)

        init {
            Itemview3.setOnClickListener {
                val position=adapterPosition
                listner.onClick(position)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view1 = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item_normal_exercise,parent,false)
        return ViewHolder(view1)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemview3 = mList3[position]
        holder.imageView1.setImageResource(itemview3.imageN)
        holder.textView2.text = itemview3.text
        holder.imageShow3.setImageResource(itemview3.image3)

    }

    override fun getItemCount(): Int
    {
        return mList3.size
    }
    interface MyClickListener
    {
        fun onClick(position: Int)
    }



}