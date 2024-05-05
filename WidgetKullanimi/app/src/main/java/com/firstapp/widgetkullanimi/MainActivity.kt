package com.firstapp.widgetkullanimi

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.firstapp.widgetkullanimi.databinding.ActivityMainBinding

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

        binding.buttonOku.setOnClickListener {
            val alinanVeri = binding.editTextGirdi.text.toString() //Edittexten veriyi al

            binding.textViewsonuc.text = alinanVeri // alınan veriyi textview 'e ekle.
        }

        binding.buttonResim1.setOnClickListener {
            //binding.imageView.setImageResource(R.drawable.resim1)

            //Eğer veritabanından resmi alacaksak aşağıdaki gibi düzenlememiz gerekiyor.

            binding.imageView.setImageResource(resources.getIdentifier("resim1","drawable", packageName))
        }

        binding.buttonResim2.setOnClickListener {
            //binding.imageView.setImageResource(R.drawable.resim2)

            //Eğer veritabanından resmi alacaksak aşağıdaki gibi düzenlememiz gerekiyor.

            binding.imageView.setImageResource(resources.getIdentifier("resim2","drawable", packageName))
        }


        binding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            //buttonView = switch1
            if( isChecked)
            {
                Log.e("Widgets","Switch: ON")
            }
            else
            {
                Log.e("Widgets","Switch: OFF")
            }
        }
    }
}