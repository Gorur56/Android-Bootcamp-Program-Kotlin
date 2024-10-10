package com.example.durumabaglibildirim

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.durumabaglibildirim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonBildir.setOnClickListener {
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
                builder.setContentTitle("Başlık")
                    .setContentText("İçerik")
                    .setSmallIcon(R.drawable.resim)
                    .setContentIntent(gidilecekIntent)
                    .setAutoCancel(true) //Bildirime tıklayınca otomatik olarak kaybolur.
            } else {
                //Oreodan eski sürüm ise;
                builder = NotificationCompat.Builder(this)
                builder.setContentTitle("Başlık")
                    .setContentText("İçerik")
                    .setSmallIcon(R.drawable.resim)
                    .setContentIntent(gidilecekIntent)
                    .setAutoCancel(true) //Bildirime tıklayınca otomatik olarak kaybolur.
                    .priority = Notification.PRIORITY_HIGH //Öncelik
            }

            //Bildirimi göster
            bildirimYoneticisi.notify(1,builder.build())
        }
    }
}