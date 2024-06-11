package com.application.livrago

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.application.livrago.domain.notifications.Constants.CHANNEL_ID
import com.application.livrago.domain.notifications.Constants.CHANNEL_NAME
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LivragoApp : Application(){
    override fun onCreate() {
        super.onCreate()


        //ce code sera execute au lancement de l'application pour android > 8

         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
             val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            )

             val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
             notificationManager.createNotificationChannel(channel)
        }
    }
}