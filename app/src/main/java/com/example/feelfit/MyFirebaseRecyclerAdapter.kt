package com.example.feelfit

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import javax.sql.DataSource

class MyFirebaseRecyclerAdapter(options: FirebaseRecyclerOptions<VegDModel>):FirebaseRecyclerAdapter<VegDModel,MyFirebaseRecyclerAdapter.MyViewHolder>(options) {
   inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
       private val amount: TextView = itemView.findViewById(R.id.vegdiet_amount)
       private val name: TextView = itemView.findViewById(R.id.vegdietFname)
       private val calorie:TextView=itemView.findViewById(R.id.calorievegd)
       private val img:ImageView=itemView.findViewById(R.id.imgdietvegf)


       fun bind(vegDModel: VegDModel) {
           amount.text=vegDModel.amount
           name.text=vegDModel.banana
           calorie.text=vegDModel.calorie
           Log.e("hhhh", "bind: ${vegDModel.img}", )
           Glide.with(itemView)
               .load(vegDModel.img).placeholder(R.drawable.malee)
               .error(R.drawable.man)
               .listener(object : RequestListener<Drawable> {
                   override fun onLoadFailed(
                       e: GlideException?,
                       model: Any?,
                       target: com.bumptech.glide.request.target.Target<Drawable>?,
                       isFirstResource: Boolean
                   ): Boolean {
                       Log.d("Glide", "Image loading failed: ${e?.message}")
                       return false
                   }

                   override fun onResourceReady(
                       resource: Drawable?,
                       model: Any?,
                       target: com.bumptech.glide.request.target.Target<Drawable>?,
                       dataSource: com.bumptech.glide.load.DataSource?,
                       isFirstResource: Boolean
                   ): Boolean {
                       return false
                   }
               })
               .into(img)

       }
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
      val view= LayoutInflater.from(parent.context).inflate(R.layout.item_vegdiet_fragment, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int, vegDModel: VegDModel) {
        holder.bind(vegDModel)
    }
}