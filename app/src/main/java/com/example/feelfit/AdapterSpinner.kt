package com.example.feelfit

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdapterSpinner(internal var context: Context, internal var images: IntArray, internal var breakfast: Array<String>):
                BaseAdapter()
{

    internal var inflter: LayoutInflater
    init
    {
        inflter = LayoutInflater.from(context)

    }
    override fun getCount(): Int {
        return images.size
    }

    override fun getItem(i: Int): Any? {
        return null
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(i: Int, view: View?, viewgroup: ViewGroup?): View {
        val view = inflter.inflate(R.layout.activity_custom_spinner,null)
        val icon = view.findViewById<View>(R.id.imageview) as ImageView?
        val names = view.findViewById<View>(R.id.textview) as TextView?
        icon!!.setImageResource(images[i])
        names!!.text = breakfast[i]
        return view
    }
}