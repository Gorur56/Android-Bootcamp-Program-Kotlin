package com.example.filmlerapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.databinding.CardTasarimBinding
import com.example.filmlerapp.databinding.FragmentAnasayfaBinding

class FilmlerAdapter( var mContext:Context, var filmlerListesi:List<Filmler>)
    : RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>(){
    //inner class card üzerindeki görsel nesneler erişmek için kullanılır.
    inner class CardTasarimTutucu(var tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        //Burada ViewBinding yapıyoruz.
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        //holder: Görsel nesnelere erişimimizi sağlar.
        val film = filmlerListesi.get(position)
        val t = holder.tasarim

        t.imageViewFilm.setImageResource(
            mContext.resources.getIdentifier(film.resim,"drawable",mContext.packageName))

        t.textViewFiyat.text = "${film.fiyat} $"
    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }
}
