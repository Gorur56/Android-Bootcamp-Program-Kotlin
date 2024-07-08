package com.example.sozlukuygulamasi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class KelimlerAdapter(private  val mContext:Context, private val kelimelerListesi:List<Kelimeler>)
    : RecyclerView.Adapter<KelimlerAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(tasarim:View) : RecyclerView.ViewHolder(tasarim){
        var cardview:CardView
        var textViewIngilizce:TextView
        var textViewTurkce:TextView

        init{
            cardview = tasarim.findViewById(R.id.cardview)
            textViewIngilizce = tasarim.findViewById(R.id.textViewIngilizce)
            textViewTurkce = tasarim.findViewById(R.id.textViewTurkce)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.card_tasarim, parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return kelimelerListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        TODO("Not yet implemented")
    }
}