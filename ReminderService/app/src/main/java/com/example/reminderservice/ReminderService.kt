package com.example.reminderservice

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
import androidx.core.app.NotificationCompat

class ReminderService: Service() {
    private var reminderTime: Long = 0L
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        reminderTime = intent?.getLongExtra("reminderTime",0L) ?: 0L

        //Foregroun olarak başlat
        val  notification = createNotification("Randevu Takibi", "Servis çalışıyor...")
        startForeground(1, notification)

        // Zaman kontrolü için Handler ve Runnable kullandık
        handler = Handler(Looper.getMainLooper())
        runnable = Runnable {
            checkReminderTime()
            handler.postDelayed(runnable, 60 * 1000) //Her dakika konrol et
        }
        handler.post(runnable)

        return START_STICKY
    }

    private fun checkReminderTime() {
        val currentTime = System.currentTimeMillis()

        //Randevu saatine 1 gün kala bildirim yolla
        if( reminderTime - currentTime <= 24 * 60 * 60 * 1000 && reminderTime - currentTime > 0) {
            sendNotification("Randevu Hatırlatması", "Randevunuza 1 gün kaldı")
        }
    }

    private fun sendNotification(title: String, message: String) {
        val notification = createNotification(title, message)
        val notificaitonmanager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificaitonmanager.notify(2,notification)
    }

    private fun createNotification(title: String, message: String): Notification {
        val notificationChannelId = "REMINDER_CHANNEL"
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
            val channel = NotificationChannel(
                notificationChannelId,
                "Reminder Notifications",
                NotificationManager.IMPORTANCE_HIGH
            )
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }

        return  NotificationCompat.Builder(this, notificationChannelId)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationCompat.PRIORITY_HIGH).build()
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }
}