package com.example.foregroudservices

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Kenar boşluklarını ayarlama
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Bildirim izinlerini kontrol etme
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
                0
            )
        }

        // Servis başlatma butonu
        findViewById<Button>(R.id.startServiceButton).setOnClickListener {
            val startIntent = Intent(this, RunningService::class.java).apply {
                action = RunningService.Actions.START.toString()
            }
            startForegroundService(startIntent)
        }

        // Servis durdurma butonu
        findViewById<Button>(R.id.stopServiceButton).setOnClickListener {
            val stopIntent = Intent(this, RunningService::class.java).apply {
                action = RunningService.Actions.STOP.toString()
            }
            startService(stopIntent)
        }
    }
}
