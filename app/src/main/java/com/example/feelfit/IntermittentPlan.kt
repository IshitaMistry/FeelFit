package com.example.feelfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast

class IntermittentPlan : AppCompatActivity() {


    internal var breakfast = arrayOf("Idli Dosa","Ragi OR Oats","Upma")
    internal var images = intArrayOf(R.drawable.idlidosa,R.drawable.ragioats,R.drawable.upma)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intermittent_plan)


        val spin = findViewById<View>(R.id.spinner) as Spinner
        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@IntermittentPlan,
                "BreakFast",
                    Toast.LENGTH_SHORT
                ).show()


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        val adapterSpinner = AdapterSpinner(applicationContext,images, breakfast)
        spin.adapter = adapterSpinner
    }
}