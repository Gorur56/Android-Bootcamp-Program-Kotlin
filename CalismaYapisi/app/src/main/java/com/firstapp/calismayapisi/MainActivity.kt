package com.firstapp.calismayapisi

import android.os.Bundle
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
            Snackbar.make(it, "Merhaba", Snackbar.LENGTH_SHORT).show()
            //Butona basınca anasayfa NAsılsın olcak
            binding.textView.text = "Nasılsın"
        }
    }
}