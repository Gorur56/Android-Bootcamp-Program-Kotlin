package com.example.filmlerappdesign

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmlerappdesign.adapter.FilmlerAdapter
import com.example.filmlerappdesign.entity.Filmler
import com.example.filmlerappdesign.entity.Kategoriler
import com.example.filmlerappdesign.entity.Yonetmenler

class FilmlerActivity : AppCompatActivity() {
    private lateinit var filmList:ArrayList<Filmler>
    private lateinit var adapter: FilmlerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_filmler)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val kategori = intent.getSerializableExtra("kategoriNesne") as Kategoriler

        var toolbarFilm: Toolbar = findViewById(R.id.toolbarFilmler)
        toolbarFilm.title = "Filmler : ${kategori.kategori_ad}"
        setSupportActionBar(toolbarFilm)

        var filmRv: RecyclerView = findViewById(R.id.filmlerRv)
        filmRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL) //Yanyana iki tane kart koyar

        filmList = ArrayList()


        adapter = FilmlerAdapter(this ,filmList)
        filmRv.adapter = adapter
    }
}