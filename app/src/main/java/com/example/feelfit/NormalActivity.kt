package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NormalActivity : AppCompatActivity(), customAdapter3.MyClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)


        val recyclerView3 = findViewById<RecyclerView>(R.id.recycler_view3)
        recyclerView3.layoutManager=LinearLayoutManager(this)

        val data3 = ArrayList<itemview3>()


        data3.add(itemview3(R.drawable.gain1,R.drawable.lung,"LUNGES"))
        data3.add(itemview3(R.drawable.gain2,R.drawable.pull,"PULL-UPS"))
        data3.add(itemview3(R.drawable.gain3,R.drawable.squat,"SQUATS"))
        data3.add(itemview3(R.drawable.gain4,R.drawable.benchpress,"BENCH PRESS"))
        data3.add(itemview3(R.drawable.gain5,R.drawable.pushupss,"PUSHUP"))
        data3.add(itemview3(R.drawable.gain6,R.drawable.burpees,"GLUTE KICK"))



        val adapter3 = customAdapter3(data3,this@NormalActivity)
        recyclerView3.adapter=adapter3
        recyclerView3.setHasFixedSize(true)
    }

    override fun onClick(position: Int) {
        when(position)
        {
            0 ->
            {
                startActivity(Intent(this,Normal1::class.java))
            }
            1 ->
            {
                startActivity(Intent(this,Normal1::class.java))
            }
            2 ->
            {
                startActivity(Intent(this,Normal1::class.java))
            }
        }
    }
}