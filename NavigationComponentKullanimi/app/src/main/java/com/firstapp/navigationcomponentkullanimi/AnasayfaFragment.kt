package com.firstapp.navigationcomponentkullanimi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.firstapp.navigationcomponentkullanimi.databinding.FragmentAnasayfaBinding
import com.google.android.material.snackbar.Snackbar

class AnasayfaFragment : Fragment() {
    private lateinit var binding:FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.buttonDetay.setOnClickListener {
            //Snackbar.make(it,"Merhaba",Snackbar.LENGTH_SHORT).show()
            //binding.textView.text = "Nasılsın"

            val urun = Urunler(100,"TV")

            // Directions veri gönderende olur.
            val gecis = AnasayfaFragmentDirections.detayGecis( urun = urun, ad = "Ahmet", yas = 23, boy = 1.78f, bekar = true)

            Navigation.findNavController(it).navigate(gecis)

            //Navigation.findNavController(it).navigate(R.id.detay_gecis) //Butona basında detay sayfasına geçiş yapar.
        }

        binding.buttonGoster.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.bottom_sheet_gecis)
        }
        return binding.root
    }

    //YAŞAM DÖNGÜSÜ

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Uygulama çalıştırıldığında bir kere çalışır.
        Log.e("Yaşam Döngüsü", "onCreate")
    }

    override fun onPause() {
        super.onPause()
        //Sayfa görünmez halde çalışan fonksiyondur.
        Log.e("Yaşam Döngüsü", "onPause")
    }

    override fun onResume() {
        super.onResume()
        //Sayfa gönürken çalışır.
        Log.e("Yaşam Döngüsü", "onResume")
    }
}