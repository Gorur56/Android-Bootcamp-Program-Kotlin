package com.example.hiltkullanimi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint //Baslangıç noktası
class MainActivity : AppCompatActivity() {
    //HILT KULLANIMI: Kod tekrarın önlemek için kullanılır.
    //Hilt private değişkenleri kullanamıyor.
    @Inject //Hilt
    lateinit var kargo: Kargo
    @Inject
    lateinit var internet: Internet
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Internet ve KArgo Adrese bağımlıdır. Hilt bu bağımlılığı kolaylaştırır.
        //kargo = Kargo() //Hilt 'en dolayı nesne oluşturmaya gerek yok
        kargo.gonder()

        //internet = Internet()
        internet.basvuruYap()
    }
}