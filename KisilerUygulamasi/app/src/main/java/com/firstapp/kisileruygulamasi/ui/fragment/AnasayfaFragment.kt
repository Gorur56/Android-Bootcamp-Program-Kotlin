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
import com.firstapp.kisileruygulamasi.R
import com.firstapp.kisileruygulamasi.data.entity.Kisiler
import com.firstapp.kisileruygulamasi.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentAnasayfaBinding.inflate(inflater,container,false)

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