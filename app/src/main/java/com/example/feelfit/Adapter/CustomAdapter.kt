package com.example.feelfit.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.feelfit.ExerciseLosing
import com.example.feelfit.R
import com.example.feelfit.itemview

class customAdapter(private val mList: List<itemview>, val listner: MyClickListener):
    RecyclerView.Adapter<customAdapter.ViewHolder>(){

    inner class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {

        val imageViewNum:ImageView=itemView.findViewById(R.id.image_exercise_one)
        val textView:TextView=itemView.findViewById(R.id.text_Exercise)
        val imageShow:ImageView=itemView.findViewById(R.id.img_run)

        init {
            itemView.setOnClickListener{
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


