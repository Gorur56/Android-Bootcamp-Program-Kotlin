package com.firstapp.calismayapisi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.firstapp.calismayapisi.databinding.ActivityDetayBinding

class DetayActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val gelenAd = intent.getStringExtra("ad") //MainActivity ^de key ile burada key aynı olmalıdır.
        val gelenYas = intent.getIntExtra("yas",0) //Default 0
        val gelenBoy = intent.getDoubleExtra("boy",0.0) //Defult 0.0
        val gelenBekarDurum = intent.getBooleanExtra("bekar", true) //Default true

        binding.textViewBilgi.text = "$gelenAd - $gelenYas - $gelenBoy - $gelenBekarDurum"
    }
}