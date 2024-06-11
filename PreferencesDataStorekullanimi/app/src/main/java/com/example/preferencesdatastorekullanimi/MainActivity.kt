package com.example.preferencesdatastorekullanimi

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

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

        val ap = AppPref(this)

        CoroutineScope(Dispatchers.Main).launch {
            //Kayıt işlemleri
            ap.kayitAd("Ahmet")

            //Yukarıdaki satırın bir defa çalışması yeterli ahmet ismini hatırlayacaktır.
            //Bu şekilde silebilirsiz. Veya Uygulamayı silersekte silinir.
            ap.silAd()

            //okuma İşlemleri
            val gelenAd = ap.okuAd()
            Log.e("Gelen Ad",gelenAd) //İsim yok
        }
    }
}