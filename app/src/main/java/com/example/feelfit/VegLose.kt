package com.example.feelfit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.feelfit.DietPlanGain.fruitschart
import com.example.feelfit.DietPlanGain.proteinchart
import com.example.feelfit.DietPlanGain.vegetablechart
import com.example.feelfit.DietPlanGain.yogurtchart


class VegLose : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_veg_lose, container, false)
        val fruits11 = view.findViewById<LinearLayout>(R.id.fruitsTwo)

        Log.e("help", "++++++++++VegLose:")
        fruits11.setOnClickListener{
            val intent = Intent(activity,fruitschart::class.java)
            startActivity(intent)

        }
        val vege11 =  view.findViewById<LinearLayout>(R.id.vege2)
        vege11.setOnClickListener {
            val intent = Intent(activity,vegetablechart::class.java)
            startActivity(intent)
        }

        val yogurt11 = view.findViewById<LinearLayout>(R.id.yogurt2)
        yogurt11.setOnClickListener {
            val intent = Intent(activity,yogurtchart::class.java)
            startActivity(intent)
        }

        val almonds11 = view.findViewById<LinearLayout>(R.id.almonds)
        almonds11.setOnClickListener {
            val intent = Intent(activity,almondschart::class.java)
            startActivity(intent)

        }

        val proteinshakes2 = view.findViewById<LinearLayout>(R.id.protein2)
        proteinshakes2.setOnClickListener {
            val intent = Intent(activity,proteinchart::class.java)
            startActivity(intent)
        }

        return view
    }
}