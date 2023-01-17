package com.example.feelfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class PushUPsAct : AppCompatActivity() {

     lateinit var nextChange:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_push_ups)

        nextChange=findViewById(R.id.next_123)
        nextChange.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,ProximitySensor::class.java))
        })


    }
}