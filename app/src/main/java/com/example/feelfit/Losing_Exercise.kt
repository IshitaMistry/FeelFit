package com.example.feelfit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Losing_Exercise : AppCompatActivity(), CustomAdapter.MyClickListner {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_losing_exercise)

        val recyclerview = findViewById<RecyclerView>(R.id.recycler_view1)
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemViewModel>()

        // This loop will create 10 Views containing
        // the image with the count of view
        //for (i in 1..10) {
            data.add(ItemViewModel(R.drawable.one,R.drawable.run,"RUNNING"))
            data.add(ItemViewModel(R.drawable.tow, R.drawable.plank,"PLANCKS " ))
            data.add(ItemViewModel(R.drawable.tree,R.drawable.jumpingrope,"JUMP ROPES"))
            data.add(ItemViewModel(R.drawable.tor,R.drawable.squats,"BURPEES"))
            data.add(ItemViewModel(R.drawable.five,R.drawable.pushup,"PUSH UPS"))
            data.add(ItemViewModel(R.drawable.six,R.drawable.crunch,"CRUNCHES"))
            data.add(ItemViewModel(R.drawable.seven,R.drawable.pogohops,"POGO-HOPS"))
            data.add(ItemViewModel(R.drawable.eight,R.drawable.squat
            ,"SQUATS"))
       // }
        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data,this@Losing_Exercise)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
        recyclerview.setHasFixedSize(true)


    }
     override fun onClick(position: Int){
        when(position){
            0 ->startActivity(Intent(this,RnunningAct::class.java))
            1 ->startActivity(Intent(this,PlanckActivity::class.java))
            2 ->startActivity(Intent(this,JumpRopesActivity::class.java))
            3->startActivity(Intent(this,BurpeesAct::class.java))
            4->startActivity(Intent(this,PushUPsAct::class.java))

        }
    }










}