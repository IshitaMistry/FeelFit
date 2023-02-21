package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class ExerciseI : AppCompatActivity(), customAdapter.MyClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_i)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view1)
        recyclerView.layoutManager= LinearLayoutManager(this)


        val data = ArrayList<itemview>()

        data.add(itemview(R.drawable.gain1,R.drawable.jog,"RUNNING"))
        data.add(itemview(R.drawable.gain2,R.drawable.plank,"PLANK"))
        data.add(itemview(R.drawable.gain3,R.drawable.jumpingrope,"JUMP ROPE"))
        data.add(itemview(R.drawable.gain4,R.drawable.burpeesexercise,"BURPESS"))
        data.add(itemview(R.drawable.gain5,R.drawable.pushup,"PUSHUP"))
        data.add(itemview(R.drawable.gain6,R.drawable.crunchess,"CRUNCHES"))
//        data.add(itemview(R.drawable.exercise,R.drawable.exercise,"RUNNING"))
//        data.add(itemview(R.drawable.exercise,R.drawable.exercise,"RUNNING"))
//        data.add(itemview(R.drawable.exercise,R.drawable.exercise,"RUNNING"))

        val adapter = customAdapter(data,this@ExerciseI)
        recyclerView.adapter=adapter
        recyclerView.setHasFixedSize(true)






//        fun main(args: Array<itemview>)
//        {
//            val mList = listOf<>()
//            val element = ""
//            val index = mList.indexOf(itemview())
//        }

//      adapter.onItemClick = {
//          val intent = Intent(this,Exercise_details_one::class.java)
//            intent.putExtra("",it)
//            startActivity(intent)
//      }
//
//        adapter.onItemClick = {
//            val intent = Intent(this,Exercise_details_two::class.java)
//            intent.putExtra("",it)
//            startActivity(intent)
//        }
    }

    override fun onClick(position: Int) {

        when(position)
        {
            0 -> {startActivity(Intent(this,Exercise_details_one::class.java))}
            1 -> {startActivity(Intent(this,Exercise_details_two::class.java))}
            2 -> {startActivity(Intent(this,Exercise_details_three::class.java))}
            3 -> {startActivity(Intent(this,Exercise_details_four::class.java))}
            4 -> {startActivity(Intent(this,Exercise_details_five::class.java))}
            5 -> {startActivity(Intent(this,Exercise_details_six::class.java))}

        }
    }

}