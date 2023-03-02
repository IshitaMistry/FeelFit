package com.example.feelfit

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class water: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        showNotification(context!!, "Shubham", "DRINK WATER", "Drink Water")


    }
    private fun showNotification(
        context: Context,
        ChannelID: String,
        notificationTitle: String,
        Notificationmsg: String)
    {
        val mChannel: NotificationChannel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            mChannel = NotificationChannel(ChannelID, "Shubham", NotificationManager.IMPORTANCE_HIGH)
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
            val builder = NotificationCompat.Builder(context, ChannelID)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle(notificationTitle)
                .setContentText(Notificationmsg)
                .setChannelId(ChannelID)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
            val intent = Intent(context, Reminder::class.java)

            val pendingIntent: PendingIntent
            pendingIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            {
                PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
            } else
            {
                PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            }
            builder.setContentIntent(pendingIntent)
            notificationManager.notify(123, builder.build())
        }
    }
}