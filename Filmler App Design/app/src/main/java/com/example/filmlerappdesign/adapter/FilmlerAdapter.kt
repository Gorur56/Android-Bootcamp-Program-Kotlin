package com.example.filmlerappdesign.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.filmlerappdesign.R
import com.example.filmlerappdesign.entity.Filmler

class FilmlerAdapter( private val mContext: Context,
                      private val filmlerList:List<Filmler>)
    : RecyclerView.Adapter<FilmlerAdapter.CardDesignHolder>(){

    inner class CardDesignHolder( design:View ) : RecyclerView.ViewHolder(design){
        var film_card:CardView
        var textviewFilmAd: TextView
        var imageViewFilmResim: ImageView

        init {
            film_card = design.findViewById(R.id.cardViewFilm)
            textviewFilmAd = design.findViewById(R.id.textViewFilmAd)
            imageViewFilmResim = design.findViewById(R.id.imageViewFilmResim)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val design = LayoutInflater.from(mContext).inflate(R.layout.film_card_tasarim,parent,false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val film = filmlerList.get(position)

        holder.textviewFilmAd.text = film.film_ad
        holder.imageViewFilmResim.setImageResource(mContext.resources.getIdentifier(film.film_resim
            ,"drawable", mContext.packageName)) //Dinamik resim gösterme

        holder.film_card.setOnClickListener {
            
        }

    }

    override fun getItemCount(): Int {
        return filmlerList.size
    }
}