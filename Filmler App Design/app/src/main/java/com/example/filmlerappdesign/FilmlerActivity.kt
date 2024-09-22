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

        val k = Kategoriler(1,"Dram")

        val y = Yonetmenler(1,"Quentin Tarantino")

        val f1 = Filmler(1,"Django",2008,"django",k,y)
        val f2 = Filmler(2,"Inception",2009,"inception",k,y)
        val f3 = Filmler(3,"The Pianist",2010,"thepianist",k,y)

        filmList.add(f1)
        filmList.add(f2)
        filmList.add(f3)

        adapter = FilmlerAdapter(this ,filmList)
        filmRv.adapter = adapter
    }
}