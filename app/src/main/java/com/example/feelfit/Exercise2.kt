package com.example.feelfit
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class Exercise2 : AppCompatActivity(), customAdapter2.MyClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise2)




        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view2)
        recyclerView.layoutManager= LinearLayoutManager(this)

        val data2 = ArrayList<itemview2>()

        data2.add(itemview2(R.drawable.gain1,R.drawable.lung,"LUNGES"))
        data2.add(itemview2(R.drawable.gain2,R.drawable.pull,"PULL-UPS"))
        data2.add(itemview2(R.drawable.gain3,R.drawable.squat,"SQUATS"))
        data2.add(itemview2(R.drawable.gain4,R.drawable.benchpress,"BENCH PRESS"))
        data2.add(itemview2(R.drawable.gain5,R.drawable.pushupss,"PUSHUP"))
        data2.add(itemview2(R.drawable.gain6,R.drawable.burpees,"GLUTE KICK"))



        val adapter2 = customAdapter2(data2, this@Exercise2)
        recyclerView.adapter=adapter2
        recyclerView.setHasFixedSize(true)

        var back=findViewById<ImageView>(R.id.backpress253)

        back.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,Dashboard::class.java))
        })



    }

    override fun onClick(position: Int) {

        when(position)
        {
            0 ->
            {
                startActivity(Intent(this,gaining1::class.java))
            }
            1 ->
            {
                startActivity(Intent(this,gaining2::class.java))
            }
            2 ->
            {
                startActivity(Intent(this,gaining3::class.java))
            }
            3 ->
            {
                startActivity(Intent(this,gaining4::class.java))
            }
            4 ->
            {
                startActivity(Intent(this,gaining5::class.java))
            }
            5 ->
            {
                startActivity(Intent(this,gaining6::class.java))
            }
        }





    }
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(applicationContext,Dashboard::class.java))
        finish()
    }
}