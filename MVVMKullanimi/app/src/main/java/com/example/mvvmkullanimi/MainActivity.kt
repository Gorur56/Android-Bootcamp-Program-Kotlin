package com.example.mvvmkullanimi

import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.mvvmkullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //binding = ActivityMainBinding.inflate(layoutInflater)

        //DataBinding => Görsel tasarım kodlarını daha çok layout dosyasına aktarır
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Diğer kısınlar ViewBinding ile aynıdır.
        binding.textVieSonuc.text = "0"

        /*binding.buttonTopla.setOnClickListener {
            val alinanSayi1 = binding.editTextTextSayi1.text.toString()
            val alinanSayi2 = binding.editTextTextSAyi2.text.toString()

            val sayi1 = alinanSayi1.toInt()
            val sayi2 = alinanSayi2.toInt()

            val toplam = sayi1 + sayi2

            binding.textVieSonuc.text = toplam.toString()
        }

        binding.buttonCarpma.setOnClickListener {
            val alinanSayi1 = binding.editTextTextSayi1.text.toString()
            val alinanSayi2 = binding.editTextTextSAyi2.text.toString()

            val sayi1 = alinanSayi1.toInt()
            val sayi2 = alinanSayi2.toInt()

            val carpma = sayi1 * sayi2
            binding.textVieSonuc.text = carpma.toString()
        }*/
    }

    fun buttonToplamaTikla(){
        val alinanSayi1 = binding.editTextTextSayi1.text.toString()
        val alinanSayi2 = binding.editTextTextSAyi2.text.toString()

        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()

        val toplam = sayi1 + sayi2

        binding.textVieSonuc.text = toplam.toString()
    }

    fun buttonCarpmaTikla(){
        val alinanSayi1 = binding.editTextTextSayi1.text.toString()
        val alinanSayi2 = binding.editTextTextSAyi2.text.toString()

        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()

        val carpma = sayi1 * sayi2
        binding.textVieSonuc.text = carpma.toString()
    }
}