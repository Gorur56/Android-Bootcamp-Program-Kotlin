package com.example.animasyonlufabbutonlari

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.animasyonlufabbutonlari.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

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

        binding.fabMain.setOnClickListener {
            Snackbar.make(it,"Merhaba ben Main FAB", Snackbar.LENGTH_SHORT).show()
        }

        binding.fabBirinci.setOnClickListener {
            Snackbar.make(it,"Merhaba ben Birinci FAB", Snackbar.LENGTH_SHORT).show()
        }

        binding.fabIkinci.setOnClickListener {
            Snackbar.make(it,"Merhaba ben İkinci FAB", Snackbar.LENGTH_SHORT).show()
        }

    }
}