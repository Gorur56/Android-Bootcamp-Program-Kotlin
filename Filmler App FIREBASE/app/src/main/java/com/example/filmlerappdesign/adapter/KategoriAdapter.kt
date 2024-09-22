package com.example.filmlerappdesign.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.filmlerappdesign.FilmlerActivity
import com.example.filmlerappdesign.R
import com.example.filmlerappdesign.entity.Kategoriler

class KategoriAdapter( private val mContext: Context,
                       private val kategoriList:List<Kategoriler>)
    : RecyclerView.Adapter<KategoriAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(design: View) : RecyclerView.ViewHolder(design) {
        var kategori_card:CardView
        var textViewKategoriAd:TextView

        init {
            kategori_card = design.findViewById(R.id.cardViewKategori)
            textViewKategoriAd = design.findViewById(R.id.textViewKagetoriAd)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val design = LayoutInflater.from(mContext).inflate(R.layout.kategori_card_tasarim, parent, false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val kategori = kategoriList.get(position)
        holder.textViewKategoriAd.text = kategori.kategori_ad

        holder.kategori_card.setOnClickListener {
            val intent = Intent(mContext, FilmlerActivity::class.java)
            intent.putExtra("kategoriNesne",kategori)
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return kategoriList.size
    }
}