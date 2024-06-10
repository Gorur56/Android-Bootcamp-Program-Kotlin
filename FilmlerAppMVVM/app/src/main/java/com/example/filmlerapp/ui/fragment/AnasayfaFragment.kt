package com.example.filmlerapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmlerapp.R
import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.databinding.FragmentAnasayfaBinding
import com.example.filmlerapp.ui.adapter.FilmlerAdapter

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container,false)
        binding.anasayfaToolbarBaslik = "Filmler"

        //Aşağıdaki kodu layout 'a taşıdık
        //binding.filmRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val filmlerListesi = ArrayList<Filmler>()

        val f1 = Filmler(1,"Djongo", "django",24)
        val f2 = Filmler(2,"Interstellar", "interstellar",32)
        val f3 = Filmler(1,"Inception", "inception",16)
        val f4 = Filmler(1,"The Hateful Eight", "thehatefuleight",28)
        val f5 = Filmler(1,"The Pianist", "thepianist",24)
        val f6 = Filmler(1,"Anadoluda", "anadoluda",24)

        filmlerListesi.add(f1)
        filmlerListesi.add(f2)
        filmlerListesi.add(f3)
        filmlerListesi.add(f4)
        filmlerListesi.add(f5)
        filmlerListesi.add(f6)

        val filmlerAdapter = FilmlerAdapter(requireContext(),filmlerListesi)

        // binding.filmRv.adapter = filmlerAdapter layout dosyasına taşındıç
        binding.filmlerAdapter = filmlerAdapter
        return binding.root
    }
}