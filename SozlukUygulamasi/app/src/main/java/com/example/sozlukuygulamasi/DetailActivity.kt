package com.example.sozlukuygulamasi

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val kelime = intent.getSerializableExtra("nesne") as? Kelimeler

        if (kelime != null) {
            val textViewIngilizceDetay: TextView = findViewById(R.id.textViewIngilizceDetay)
            textViewIngilizceDetay.text = kelime.ingilizce

            val textViewTurkceDetay: TextView = findViewById(R.id.textViewTurkceDetay)
            textViewTurkceDetay.text = kelime.turkce
        } else {
            // kelime nesnesi null ise hata mesajı veya diğer işlemler
            Log.e("DetailActivity", "Kelime verisi bulunamadı.")
        }


    }
}