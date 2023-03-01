package com.example.feelfit

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout


class VegDietPlan : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_veg, container, false)

        val fruits1 = view.findViewById<LinearLayout>(R.id.fruitsOne)
        fruits1.setOnClickListener{
            val intent = Intent(activity,fruitschart::class.java)
            startActivity(intent)

        }
        return view
    }
}