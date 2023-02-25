package com.example.feelfit.LosingExercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.feelfit.*
import com.example.feelfit.Adapter.customAdapter
import java.util.ArrayList

class ExerciseI : AppCompatActivity(), customAdapter.MyClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_i)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view1)
        recyclerView.layoutManager= LinearLayoutManager(this)


        val data = ArrayList<itemview>()

        data.add(itemview(R.drawable.gain1, R.drawable.jog,"RUNNING"))
        data.add(itemview(R.drawable.gain2, R.drawable.plank,"PLANK"))
        data.add(itemview(R.drawable.gain3, R.drawable.jumpingrope,"JUMP ROPE"))
        data.add(itemview(R.drawable.gain4, R.drawable.burpeesexercise,"BURPESS"))
        data.add(itemview(R.drawable.gain5, R.drawable.pushup,"PUSHUP"))
        data.add(itemview(R.drawable.gain6, R.drawable.crunchess,"CRUNCHES"))

        val adapter = customAdapter(data,this@ExerciseI)
        recyclerView.adapter=adapter
        recyclerView.setHasFixedSize(true)

        var back=findViewById<ImageView>(R.id.backpress253)
        back.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, Dashboard::class.java))
        })

    }

    override fun onClick(position: Int) {

        when(position)
        {
            0 -> {startActivity(Intent(this, Exercise_details_one::class.java))}
            1 -> {startActivity(Intent(this, Exercise_details_two::class.java))}
            2 -> {startActivity(Intent(this, Exercise_details_three::class.java))}
            3 -> {startActivity(Intent(this, Exercise_details_four::class.java))}
            4 -> {startActivity(Intent(this, Exercise_details_five::class.java))}
            5 -> {startActivity(Intent(this, Exercise_details_six::class.java))}
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(applicationContext, Dashboard::class.java))
        finish()
    }
}