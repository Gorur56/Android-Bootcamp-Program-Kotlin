package com.firstapp.calismayapisi

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.firstapp.calismayapisi.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater) //layoutInflater: Görsel tasarımları aktarmamızı sağlar.
        setContentView(binding.root) //TAsarımı bağlamış oluyoruz.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonDetay.setOnClickListener {
            //Snackbar.make(it, "Merhaba", Snackbar.LENGTH_SHORT).show()

            //Butona basınca anasayfa NAsılsın olcak
            //binding.textView.text = "Nasılsın"

            val intent = Intent(this@MainActivity, DetayActivity::class.java)

            //Veri transferi yapabilmek için sayfa geçişi olamk zorundadır.
            intent.putExtra("ad","Ahmet") //key,Value
            intent.putExtra("yas",23)
            intent.putExtra("boy",1.78)
            intent.putExtra("bekar",true)
            startActivity(intent)


        }
    }
}