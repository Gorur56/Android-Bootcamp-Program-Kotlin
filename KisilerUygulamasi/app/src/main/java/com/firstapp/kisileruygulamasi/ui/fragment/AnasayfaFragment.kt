package com.firstapp.kisileruygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.firstapp.kisileruygulamasi.R
import com.firstapp.kisileruygulamasi.databinding.ActivityMainBinding
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

        return binding.root
    }
}