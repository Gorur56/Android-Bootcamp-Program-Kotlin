package com.example.foregroudservices

import android.app.Application
import android.app.NotificationChannel
import android.os.Build

class RunningApp : Application {

    override fun onCreate() {
        super.onCreate()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                
            )
        }
    }
}