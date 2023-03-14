package com.example.feelfit

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.feelfit.DietPlanGain.*


class nonveg_diet_plan : Fragment() {


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_nonveg, container, false)
        val fruit1 = view.findViewById<LinearLayout>(R.id.fruit2)
        fruit1.setOnClickListener{
            val intent = Intent(activity, fruitschart::class.java)
            startActivity(intent)
        }

        val veges2 = view.findViewById<LinearLayout>(R.id.vege2)
        veges2.setOnClickListener {
            val intent = Intent(activity, vegechartGain::class.java)
            startActivity(intent)
        }

        val chicken = view.findViewById<LinearLayout>(R.id.chicken1)
        chicken.setOnClickListener {
            val intent = Intent(activity, chickenchart::class.java)
            startActivity(intent)
        }

        val yogs11 = view.findViewById<LinearLayout>(R.id.yogs)
        yogs11.setOnClickListener {
            val intent = Intent(activity, yogurtchart::class.java)
            startActivity(intent)
        }
        val egg = view.findViewById<LinearLayout>(R.id.eggss)
        egg.setOnClickListener {
                val intent = Intent(activity, egg::class.java)
            startActivity(intent)
        }
        return view
    }
}