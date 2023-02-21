package com.example.feelfit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class customAdapter(private val mList: List<itemview>, val listner: MyClickListener):
    RecyclerView.Adapter<customAdapter.ViewHolder>(){


    //var onItemClick : ((itemview) -> Unit)? = null
    inner class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {
        val imageViewNum:ImageView=ItemView.findViewById(R.id.image_exercise_one)
        val textView:TextView=ItemView.findViewById(R.id.text_Exercise)
        val imageShow:ImageView=ItemView.findViewById(R.id.img_run)

        init {
            ItemView.setOnClickListener{
                val position=adapterPosition
                listner.onClick(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_losing_exercise,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val itemview = mList[position]
        holder.imageViewNum.setImageResource(itemview.image)
        holder.textView.text = itemview.text
        holder.imageShow.setImageResource(itemview.image1)

//        holder.itemView.setOnClickListener{
//            onItemClick?.invoke(itemview)
//        }
    }

    override fun getItemCount(): Int
    {
        return mList.size

    }
    interface MyClickListener
    {
        fun onClick(position: Int)
    }


}