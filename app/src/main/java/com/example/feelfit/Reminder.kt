package com.example.feelfit

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Reminder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reminder)

//        val intent = Intent(this, water::class.java)
//        val pendingIntent: PendingIntent
//        pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
//        } else {
//            PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
//        }
//        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
//        alarmManager.setRepeating(
//            AlarmManager.RTC_WAKEUP,
//            System.currentTimeMillis(),
//            REMINDER_INTERVAL_MILLIS.toLong(),
//            pendingIntent
//        )
    }
//    companion object {
//        private const val REMINDER_INTERVAL_MILLIS = 30 * 60 * 1000
//    }
}
