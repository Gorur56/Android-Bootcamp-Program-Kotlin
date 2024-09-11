package com.example.notlaruygulamasdesign

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.notlaruygulamasdesign.databinding.ActivityMainBinding
import com.example.notlaruygulamasdesign.databinding.ActivityNotKayitBinding

class NotKayitActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotKayitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityNotKayitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.notKayitActivityToolbarTitle = "Not Kayıt"
        setSupportActionBar(binding.toolbarNotKayit)

        binding.buttonKaydet.setOnClickListener {
            startActivity(Intent(this@NotKayitActivity, MainActivity::class.java))
            finish()
        }
    }
}