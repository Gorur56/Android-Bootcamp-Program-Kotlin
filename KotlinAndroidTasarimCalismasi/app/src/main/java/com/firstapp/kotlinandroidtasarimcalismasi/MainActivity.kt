package com.firstapp.kotlinandroidtasarimcalismasi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Yazılım kısmında R harfi res klasörünü temsil eder.
        //Xml kısmında @ işareti res klasörünü temsil eder. Manifeast dosyası gibi.
        //Left(Android) - Start(android) - Leading (ios) //Bunlar Görsel nesnein sol kısmınız simgeler.
        //Right - End (Android) - Trailing (ios) //Bunlar Görsel nesnein sağ kısmınız simgeler.
    }
}