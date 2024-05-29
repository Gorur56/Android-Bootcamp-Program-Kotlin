package com.firstapp.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.firstapp.kisileruygulamasi.R
import com.firstapp.kisileruygulamasi.data.entity.Kisiler
import com.firstapp.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.firstapp.kisileruygulamasi.ui.adapter.KisilerAdapter

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentAnasayfaBinding.inflate(inflater,container,false)

        //Aşağıdaki kod listenin itemlarının alt alta görünmesini sağlar.
        binding.rv.layoutManager = LinearLayoutManager(requireContext())

        //Bir sutünda birden fazla görünmesini istiyorsak;
        //VERTICAL: dikeyde scroll edeceğimiz anlamına geliyor.
        //binding.rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        //Veya yandan kaydırmak istersek
        //binding.rv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)

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
        val kisilerAdapter = KisilerAdapter(requireContext(),kisilerListesi)

        //Bu adapter 'ı recycleView 'e atıyoruz. Yoksa görüntülenme olmaz.
        binding.rv.adapter = kisilerAdapter

        binding.fab.setOnClickListener{
            //fab 'a basınca kisiKayırGEcis sayfasına geçecektir.
            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis) // it == binding.fab
        }

        /*binding.detay.setOnClickListener {
            //Geçici veri göndererek geçiş yapmak
            val kisi = Kisiler(1, "Ahmet", "1111")

            //Gönderen sınıf Directions sonuna gelir.
            //İlk kisi fragment 'de oluşturduğumuz argument kisi nesnesidir. ikinci kisi yukarıda oluşturulan kisi nesnesidir.
            val gecis = AnasayfaFragmentDirections.kisiDEtayGecis( kisi = kisi)
            //Navigation.findNavController(it).navigate(R.id.kisiDEtayGecis)

            Navigation.findNavController(it).navigate(gecis)
        }*/

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

    fun ara(arananKelime:String)
    {
        Log.e("Aranan Kelime: ","$arananKelime")
    }
}