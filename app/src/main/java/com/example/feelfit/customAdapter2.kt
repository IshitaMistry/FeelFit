package com.example.feelfit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.feelfit.customAdapter2.*

class customAdapter2(private val mList2: List<itemview2>, val listner: MyClickListener):
        RecyclerView.Adapter<customAdapter2.ViewHolder>()
        {
            inner class ViewHolder(ItemView2:View):RecyclerView.ViewHolder(ItemView2) {

                val imageView:ImageView=ItemView2.findViewById(R.id.exercise_one)
                val textView1: TextView=ItemView2.findViewById(R.id.text2_Exercise)
                val imageShow2:ImageView=ItemView2.findViewById(R.id.img2)

                init {
                    ItemView2.setOnClickListener {
                        val position=adapterPosition
                        listner.onClick(position)
                    }

                }
            }


            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.activity_item_gaining_exercise,parent,false)
                return ViewHolder(view)
            }

            override fun onBindViewHolder(holder: ViewHolder, position: Int)
            {
                val itemview = mList2[position]
                holder.imageView.setImageResource(itemview.imageG)
                holder.textView1.text = itemview.text
                holder.imageShow2.setImageResource(itemview.image2)

            }

            override fun getItemCount(): Int
            {
                return mList2.size
            }
            interface MyClickListener
            {
                fun onClick(position: Int)
            }

        }