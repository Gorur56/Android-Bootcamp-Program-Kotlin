package com.example.internetbildirimuygulama

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MessageService : FirebaseMessagingService(){
    override fun onMessageReceived(rm: RemoteMessage) {
        super.onMessageReceived(rm)

        val baslik = rm?.notification?.title
        val icerik = rm?.notification?.body

        baslik?.let {
            Log.d("baslik",it)
        } ?: Log.d("baslik","Başlık değeri null")

        icerik?.let{
            Log.d("icerik",it)
        } ?: Log.d("icerik","İçerik değeri null")
    }

    fun bildirimOlustur(baslik:String?, icerik:String?) {
        val builder: NotificationCompat.Builder

        val bildirimYoneticisi = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intent = Intent(this, MainActivity::class.java) //Bildirimin gösterileceği activity

        val gidilecekIntent = PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT)

        //Genel tanımlamalar bitti şimdi bildirimi oluşturuyoruz.
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
            //Oreo ve üzeri sürüm ise;

            val kanalId = "kanalId"
            val kanalAd = "KanalAd"
            val kanalTanitim = "KanalTanıtım"
            val kanalOnceligi = NotificationManager.IMPORTANCE_HIGH

            var kanal: NotificationChannel? = bildirimYoneticisi.getNotificationChannel(kanalId)

            if( kanal == null) {
                kanal = NotificationChannel(kanalId,kanalAd,kanalOnceligi)
                kanal.description = kanalTanitim
                bildirimYoneticisi.createNotificationChannel(kanal)
            }

            builder = NotificationCompat.Builder(this, kanalId)
            builder.setContentTitle(baslik)
                .setContentText(icerik)
                .setSmallIcon(R.drawable.resim)
                .setContentIntent(gidilecekIntent)
                .setAutoCancel(true) //Bildirime tıklayınca otomatik olarak kaybolur.
        } else {
            //Oreodan eski sürüm ise;
            builder = NotificationCompat.Builder(this)
            builder.setContentTitle(baslik)
                .setContentText(icerik)
                .setSmallIcon(R.drawable.resim)
                .setContentIntent(gidilecekIntent)
                .setAutoCancel(true) //Bildirime tıklayınca otomatik olarak kaybolur.
                .priority = Notification.PRIORITY_HIGH //Öncelik
        }

        //Bildirimi göster
        bildirimYoneticisi.notify(1,builder.build())
    }

}