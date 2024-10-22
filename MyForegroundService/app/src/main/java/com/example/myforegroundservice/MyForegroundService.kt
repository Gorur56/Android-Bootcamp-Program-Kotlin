package com.example.myforegroundservice

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.widget.Toast
import androidx.core.app.NotificationCompat
import java.util.concurrent.Executors

class MyForegroundService : Service() {
    private var content: Context? = null
    private val NOTIFICATION_ID = 1
    private val CHANNEL_ID = "100"
    private var isDestroyed = false

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    @SuppressLint("ForegroundServiceType")
    override fun onCreate() {
        super.onCreate()
        content = this
        startForeground(NOTIFICATION_ID, showNotification("This is content."))
    }

    private fun showNotification(content: String): Notification {
        //notification design
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            (getSystemService(NOTIFICATION_SERVICE) as NotificationManager).createNotificationChannel(
                NotificationChannel(
                    CHANNEL_ID,"Forground Notification",
                    NotificationManager.IMPORTANCE_HIGH
                )
            )
        }

        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Forground Service")
            .setContentText(content)
            .setOnlyAlertOnce(true)
            .setOngoing(true)
            .setSmallIcon(R.drawable.ic_launcher_foreground).build()

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(content,"Starting serice ...", Toast.LENGTH_SHORT).show()
        doTask()
        return super.onStartCommand(intent, flags, startId)
    }

    private fun doTask() {
        val data = IntArray(1)
        val executerService = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        executerService.execute{

            for( i in 0 until 99) {
                if(isDestroyed) {
                    break
                }
                data[0] = i
                try {
                    handler.post{ //update ui
                        updateNotification(data[0].toString())
                    }
                    Thread.sleep(5000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun updateNotification( data: String) {
        val notification: Notification = showNotification(data)
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(NOTIFICATION_ID,notification)
    }

    override fun onDestroy() {
        super.onDestroy()
        isDestroyed = true
        Toast.makeText(content,"Stopping service...", Toast.LENGTH_SHORT).show()
    }
}