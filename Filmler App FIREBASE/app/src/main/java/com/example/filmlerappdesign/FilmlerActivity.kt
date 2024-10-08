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
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FilmlerActivity : AppCompatActivity() {
    private lateinit var filmList:ArrayList<Filmler>
    private lateinit var adapter: FilmlerAdapter
    private lateinit var refFilmler:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_filmler)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val db = FirebaseDatabase.getInstance()
        refFilmler = db.getReference("filmler")

        val kategori = intent.getSerializableExtra("kategoriNesne") as Kategoriler

        var toolbarFilm: Toolbar = findViewById(R.id.toolbarFilmler)
        toolbarFilm.title = "Filmler : ${kategori.kategori_ad}"
        setSupportActionBar(toolbarFilm)

        var filmRv: RecyclerView = findViewById(R.id.filmlerRv)
        filmRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL) //Yanyana iki tane kart koyar

        filmList = ArrayList()


        adapter = FilmlerAdapter(this ,filmList)
        filmRv.adapter = adapter

        filmByKategoriAd(kategori.kategori_ad)
    }

    fun filmByKategoriAd(kategori_ad:String?){
        val sorgu = refFilmler.orderByChild("kategori_ad").equalTo(kategori_ad)

        sorgu.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(d: DataSnapshot) {
                filmList.clear()

                for(c in d.children){
                    val film = c.getValue(Filmler::class.java)

                    if(film != null){
                        film.film_id = c.key
                        filmList.add(film)
                    }
                }

                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(p0: DatabaseError) {

            }
        })
    }
}