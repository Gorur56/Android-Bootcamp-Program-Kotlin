package com.example.filmlerapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.R
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.databinding.CardTasarimBinding
import com.example.filmlerapp.databinding.FragmentAnasayfaBinding
import com.example.filmlerapp.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class FilmlerAdapter( var mContext:Context, var filmlerListesi:List<Filmler>)
    : RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>(){
    //inner class card üzerindeki görsel nesneler erişmek için kullanılır.
    inner class CardTasarimTutucu(var tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        //Burada ViewBinding yapıyoruz.
        val binding:CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
            com.example.filmlerapp.R.layout.card_tasarim, parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        //holder: Görsel nesnelere erişimimizi sağlar.
        val film = filmlerListesi.get(position)
        val t = holder.tasarim

        t.imageViewFilm.setImageResource(
            mContext.resources.getIdentifier(film.resim,"drawable",mContext.packageName))

        t.filmNesnesi = film
        //t.textViewFiyat.text = "${film.fiyat} $"

        t.CardViewFilm.setOnClickListener {
            //Kartı tıklamak için
            //Veri gönderen Direction alan sınıf Args
            val gecis = AnasayfaFragmentDirections.detayGecis(film = film)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.buttonSepet.setOnClickListener {
            Snackbar.make(it,"${film.ad} sepete eklendi",Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }
}
