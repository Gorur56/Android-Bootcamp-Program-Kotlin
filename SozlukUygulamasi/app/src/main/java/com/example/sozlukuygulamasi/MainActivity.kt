package com.example.sozlukuygulamasi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var kelimelerListe:ArrayList<Kelimeler>
    private lateinit var adapter:KelimlerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title = "Sözlük Uygulaması"
        setSupportActionBar(toolbar)

        val rv: RecyclerView = findViewById(R.id.rv)
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        kelimelerListe = ArrayList()

        val k1 = Kelimeler(1, "Hello","Merhaba")
        val k2 = Kelimeler(2, "Dog","Köpek")
        val k3 = Kelimeler(3, "Fish","Balık")
        val k4 = Kelimeler(4, "Table","Masa")
        val k5 = Kelimeler(5, "Pencil","Kalem")
        val k6 = Kelimeler(6, "Sugar","Şeker")

        kelimelerListe.add(k1)
        kelimelerListe.add(k2)
        kelimelerListe.add(k3)
        kelimelerListe.add(k4)
        kelimelerListe.add(k5)
        kelimelerListe.add(k6)

        adapter = KelimlerAdapter(this,kelimelerListe)

        rv.adapter = adapter

    }
}