package com.example.feelfit

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdapterSpinner(internal var context: Context, internal var Time: Int):
                BaseAdapter()
{

    internal var inflter: LayoutInflater
    init
    {
        inflter = LayoutInflater.from(context)

    }
    override fun getCount(): Int {
        return Time
    }

    override fun getItem(i: Int): Any? {
        return null
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    @SuppressLint("ViewHolder", "InflateParams", "MissingInflatedId")
    override fun getView(i: Int, view: View?, viewgroup: ViewGroup?): View {
        val view = inflter.inflate(R.layout.activity_custom_spinner2,null)
        val names = view.findViewById<View>(R.id.textview) as TextView?
        names!!.text = Time.toString()
        return view
    }
}