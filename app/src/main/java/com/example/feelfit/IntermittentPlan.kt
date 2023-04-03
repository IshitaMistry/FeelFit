package com.example.feelfit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class IntermittentPlan : AppCompatActivity() {


    internal var breakfast = arrayOf("Idli Dosa","Ragi OR Oats","Upma")
    internal var images = intArrayOf(R.drawable.idlidosa,R.drawable.ragioats,R.drawable.upma)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intermittent_plan)

        val interm=findViewById<Button>(R.id.intermitent_fast)
        interm.setOnClickListener(View.OnClickListener {v->

            val builder=AlertDialog.Builder(v.rootView.context)
            val info=LayoutInflater.from(v.rootView.context).inflate(R.layout.custom_dialog,null)

            val text=info.findViewById<TextView>(R.id.fasting)
            text.setText(R.string.intermitentfasting)

            builder.setView(info)
            builder.setCancelable(true)
            builder.show()


        })


        val spin = findViewById<View>(R.id.spinner) as Spinner
        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@IntermittentPlan,
                "BreakFast",
                    Toast.LENGTH_SHORT
                ).show()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        val adapterSpinner = AdapterSpinner(applicationContext, R.array.Time )
        spin.adapter = adapterSpinner
    }
}