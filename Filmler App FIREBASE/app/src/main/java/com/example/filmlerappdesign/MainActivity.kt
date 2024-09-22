package com.example.filmlerappdesign

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmlerappdesign.adapter.KategoriAdapter
import com.example.filmlerappdesign.entity.Kategoriler

class MainActivity : AppCompatActivity() {
    private lateinit var kategoriList:ArrayList<Kategoriler>
    private lateinit var adapter:KategoriAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var toolbarKategori: Toolbar = findViewById(R.id.toolbarKategori)
        toolbarKategori.title = "Kategoriler"
        setSupportActionBar(toolbarKategori)

        var kagetoriRV: RecyclerView = findViewById(R.id.kagetoriRV)

        kagetoriRV.setHasFixedSize(true)
        kagetoriRV.layoutManager = LinearLayoutManager(this) //Alt Alta gösterir.

        kategoriList = ArrayList()

        val k1 = Kategoriler(1,"Komedi")
        val k2 = Kategoriler(2,"Bilim kurgu")
        val k3 = Kategoriler(3,"Dram")

        kategoriList.add(k1)
        kategoriList.add(k2)
        kategoriList.add(k3)

        adapter = KategoriAdapter(this,kategoriList)
        kagetoriRV.adapter = adapter
    }
}