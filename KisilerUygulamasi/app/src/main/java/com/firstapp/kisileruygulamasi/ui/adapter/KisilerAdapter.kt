package com.firstapp.kisileruygulamasi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firstapp.kisileruygulamasi.data.entity.Kisiler
import com.firstapp.kisileruygulamasi.databinding.CardTasarimBinding
import com.firstapp.kisileruygulamasi.databinding.FragmentAnasayfaBinding

class KisilerAdapter(var mContext: Context, var kisilerListesi:List<Kisiler>)
    : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>(){

    //Adapter Card üzerindeki işlerimleri yapmamızı sağlar. Ad, Tel ve kişiyi sil
    //özelliğini buradan yapacağız

    //inner class card tasarımını temsil eder.
    inner class CardTasarimTutucu(var tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root) //binding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        //binding kurulumu
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent,false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        //holder sayesinde tasarıma ve binding ile nesnelere ualşacağız.
        val kisi = kisilerListesi.get(position) //Kisiler sınfı

        val t = holder.tasarim //CardTasarimTutucu temsil eder.

        //t ile artık tasarım üzerindeki nesnelere erişebiliriz.
        t.textViewKisiAd.text = kisi.kisi_ad
        t.textViewKisiTel.text = kisi.kisi_tel
    }

    override fun getItemCount(): Int {
        //listede kaç tane item var.
        return kisilerListesi.size
    }
}