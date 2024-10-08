package com.example.filmlerappdesign

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.filmlerappdesign.entity.Filmler
import com.squareup.picasso.Picasso

class DetayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detay)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val film = intent.getSerializableExtra("filmNesne") as Filmler

        val textViewFilmAd: TextView = findViewById(R.id.textViewFilmAdd)
        textViewFilmAd.text = film.film_ad

        val textViewFilmYil: TextView = findViewById(R.id.textViewFilmYil)
        textViewFilmYil.text = (film.film_yil).toString()
        val textViewYonetmen: TextView = findViewById(R.id.textViewYonetmen)
        textViewYonetmen.text = film.yonetmen_ad
        val imageViewFilmResim: ImageView = findViewById(R.id.imageViewFilmResim)

        //imageViewResim.setImageResource(resources.getIdentifier(film.film_resim,"drawable",packageName))

        val url = "http://kasimadalan.pe.hu/filmler/resimler/${film.film_resim}"
        Picasso.get().load(url).into(imageViewFilmResim)
    }
}