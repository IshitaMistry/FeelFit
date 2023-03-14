package com.example.feelfit

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.feelfit.DietPlanGain.*


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
            val intent = Intent(activity, fruitsChartGain::class.java)
            startActivity(intent)

        }

        val vege1 =  view.findViewById<LinearLayout>(R.id.vege)
        vege1.setOnClickListener {
            val intent = Intent(activity, vegechartGain::class.java)
            startActivity(intent)
        }

        val rice1 = view.findViewById<LinearLayout>(R.id.rice)
        rice1.setOnClickListener {
            val intent = Intent(activity, ricechart::class.java)
            startActivity(intent)
        }

        val yogurt1 = view.findViewById<LinearLayout>(R.id.yogurt)
        yogurt1.setOnClickListener {
            val intent = Intent(activity, yogurtchart::class.java)
            startActivity(intent)
        }

        val proteinshakes = view.findViewById<LinearLayout>(R.id.protein)
        proteinshakes.setOnClickListener {
            val intent = Intent(activity, proteinchart::class.java)
            startActivity(intent)
        }
        return view
    }
}