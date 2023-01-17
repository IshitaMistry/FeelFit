package com.example.feelfit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList: List<ItemViewModel>, val listner: Losing_Exercise):
    RecyclerView.Adapter<CustomAdapter.ViewHolder>()


{



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_losing_exercise, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageViewNum.setImageResource(ItemsViewModel.image)
        holder.imageViewEx.setImageResource(ItemsViewModel.image2)
       // holder.imageViewEx.setImageResource(ItemViewModel.imagee)

        // sets the text to the textview from our itemHolder class
        holder.TextView.text = ItemsViewModel.text
    }

    override fun getItemCount(): Int {
      return mList.size
    }

   inner class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView)

    {
        val imageViewNum:ImageView=ItemView.findViewById(R.id.image_exercise_one)
        val imageViewEx:ImageView=ItemView.findViewById(R.id.img_run)
        val TextView:TextView=ItemView.findViewById(R.id.text_Exercise)
      //  val Context=ItemView.context

        init {
            ItemView.setOnClickListener {
                val position=adapterPosition
                listner.onClick(position)
            }
        }
    }

    interface MyClickListner {
        fun onClick(position: Int)


    }


}


