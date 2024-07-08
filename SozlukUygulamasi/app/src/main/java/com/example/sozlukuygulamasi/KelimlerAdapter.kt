package com.example.sozlukuygulamasi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable

class KelimlerAdapter(private  val mContext:Context, private val kelimelerListesi:List<Kelimeler>)
    : RecyclerView.Adapter<KelimlerAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(tasarim:View) : RecyclerView.ViewHolder(tasarim){
        var cardview: CardView = tasarim.findViewById(R.id.cardview)
        var textViewIngilizce: TextView = tasarim.findViewById(R.id.textViewIngilizce)
        var textViewTurkce: TextView = tasarim.findViewById(R.id.textViewTurkce)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_tasarim, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return kelimelerListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        //Gelen veri kümesini işliyoruz.
        val kelime = kelimelerListesi.get(position)
        holder.textViewIngilizce.text = kelime.ingilizce
        holder.textViewTurkce.text = kelime.turkce

        holder.cardview.setOnClickListener{
            val intent = Intent(mContext, DetailActivity::class.java)
            intent.putExtra("nesne", kelime as Serializable)
            mContext.startActivity(intent)
        }

    }
}