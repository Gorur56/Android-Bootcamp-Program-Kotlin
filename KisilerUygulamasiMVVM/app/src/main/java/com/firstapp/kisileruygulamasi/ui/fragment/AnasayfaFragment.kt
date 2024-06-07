package com.firstapp.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.firstapp.kisileruygulamasi.R
import com.firstapp.kisileruygulamasi.data.entity.Kisiler
import com.firstapp.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.firstapp.kisileruygulamasi.ui.adapter.KisilerAdapter

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa,container,false)
        binding.anaSayfaFragment = this
        binding.anasayfaToolbarBaslik = "KİŞİLER"

        //İtem oluşturma için arrayList oluşturuyoruz.
        val kisilerListesi = ArrayList<Kisiler>()

        //Kişiler nesne oluştur
        val k1 = Kisiler(1, "Ahmet", "523634896")
        val k2 = Kisiler(2,"Mehmet","1234567852")
        val k3 = Kisiler(3,"Ayşe","5289634578")

        //Nesneleri arrayliste ekle
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)

        //Adapter Nesne Oluştur
        //Bu adapter 'ı recycleView 'e atıyoruz. Yoksa görüntülenme olmaz.
        val kisilerAdapter = KisilerAdapter(requireContext(),kisilerListesi)
        binding.kisilerAdapter = kisilerAdapter

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                //Harf girdikçe veya sildikçe arama yapar
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                //Arama ikonuna basınca bize sonuç getirir.
                ara(query)
                return true
            }

        })

        return binding.root
    }
    fun fabTikla(it:View){
        Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
    }

    fun ara(arananKelime:String)
    {
        Log.e("Aranan Kelime: ","$arananKelime")
    }
}