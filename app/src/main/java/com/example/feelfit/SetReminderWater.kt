package com.example.feelfit

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView

import com.example.feelfit.databinding.ActivitySetReminderWaterBinding


class SetReminderWater : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var textView1: TextView
    lateinit var show:TextView
    private lateinit var binding: ActivitySetReminderWaterBinding
    lateinit var pendingIntent1: PendingIntent
    var REMINDER_INTERVAL_MILLIS=0

    private lateinit var sharedPreferences: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetReminderWaterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textView1 = findViewById(R.id.TextSpinner)
        show=findViewById(R.id.textshare)


        cancelAlarm()

        valueToSharedPref()


        val Adapter = ArrayAdapter.createFromResource(this, R.array.Time, android.R.layout.simple_spinner_item)
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner1.adapter = Adapter
        binding.spinner1.onItemSelectedListener = this

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    }



    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val text: String = parent?.getItemAtPosition(position).toString()
        textView1.text = text
        var value=text.toInt()
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        editor.putInt("MyNumber", value)
        editor.apply()
         userInput()

}
    private fun valueToSharedPref() {

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().putInt("MyNumber", 8).apply()
        val savedNumber = sharedPreferences.getInt("MyNumber", 0)
        show.text=savedNumber.toString()
        REMINDER_INTERVAL_MILLIS=savedNumber*60*1000


    }

    private fun userInput() {
        var intent = Intent(this, water::class.java)
        val pendingIntent: PendingIntent
        pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        } else {
            PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        }
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), REMINDER_INTERVAL_MILLIS.toLong(), pendingIntent)
        Log.e("dsa", "bsc======:$REMINDER_INTERVAL_MILLIS ", )

    }

    private fun cancelAlarm() {
        var intent = Intent(this, water::class.java)
        val pendingIntent1: PendingIntent
        pendingIntent1 = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        } else {
            PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        }
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), REMINDER_INTERVAL_MILLIS.toLong(), pendingIntent1)
        alarmManager.cancel(pendingIntent1)

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {


    }



}