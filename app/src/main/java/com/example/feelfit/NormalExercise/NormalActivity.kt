package com.example.feelfit.NormalExercise

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.feelfit.*
import com.example.feelfit.Adapter.customAdapter3

class NormalActivity : AppCompatActivity(), customAdapter3.MyClickListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)


        val recyclerView3 = findViewById<RecyclerView>(R.id.recycler_view3)
        recyclerView3.layoutManager=LinearLayoutManager(this)

        val data3 = ArrayList<itemview3>()


        data3.add(itemview3(R.drawable.gain1, R.drawable.lung,"LUNGES"))
        data3.add(itemview3(R.drawable.gain2, R.drawable.pull,"PULL-UPS"))
        data3.add(itemview3(R.drawable.gain3, R.drawable.squat,"SQUATS"))
        data3.add(itemview3(R.drawable.gain4, R.drawable.benchpress,"BENCH PRESS"))
        data3.add(itemview3(R.drawable.gain5, R.drawable.pushupss,"PUSHUP"))



        val adapter3 = customAdapter3(data3,this@NormalActivity)
        recyclerView3.adapter=adapter3
        recyclerView3.setHasFixedSize(true)

        val back=findViewById<ImageView>(R.id.backpress253)
        back.setOnClickListener{
            startActivity(Intent(this, Dashboard::class.java))
        }
    }

    override fun onClick(position: Int) {
        when(position)
        {
            0 ->
            {
                startActivity(Intent(this, Normal1::class.java))
            }
            1 ->
            {
                startActivity(Intent(this, Normal2::class.java))
            }
            2 ->
            {
                startActivity(Intent(this, Normal3::class.java))
            }
            3 ->
            {
                startActivity(Intent(this,Normal4::class.java))
            }
            4 ->
            {
                startActivity(Intent(this,Normal5::class.java))
            }
        }
    }
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(applicationContext, Dashboard::class.java))
        finish()
    }
}