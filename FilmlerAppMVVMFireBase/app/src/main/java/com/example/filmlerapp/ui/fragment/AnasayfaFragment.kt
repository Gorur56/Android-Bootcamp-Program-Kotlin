package com.example.filmlerapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.filmlerapp.R
import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.databinding.FragmentAnasayfaBinding
import com.example.filmlerapp.ui.adapter.FilmlerAdapter
import com.example.filmlerapp.ui.viewmodel.AnasayfaViewModel
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)
        binding.anasayfaToolbarBaslik = "Filmler"

        viewModel.filmlerListesi.observe(viewLifecycleOwner){
            val filmlerAdapter = FilmlerAdapter(requireContext(),it)
            binding.filmlerAdapter = filmlerAdapter
        }

     /*   Firebase'de tablo oluşturdu. Bir kere çalıştıktan sonra burayı kapat.
        val db = Firebase.firestore
        val collectionFilmler = db.collection("Filmler")

        val f1 = Filmler("","Djongo", "django",24)
        val f2 = Filmler("","Interstellar", "interstellar",32)
        val f3 = Filmler("","Inception", "inception",16)
        val f4 = Filmler("","The Hateful Eight", "thehatefuleight",28)
        val f5 = Filmler("","The Pianist", "thepianist",24)
        val f6 = Filmler("","Anadoluda", "anadoluda",24)

        collectionFilmler.document().set(f1)
        collectionFilmler.document().set(f2)
        collectionFilmler.document().set(f3)
        collectionFilmler.document().set(f4)
        collectionFilmler.document().set(f5)
        collectionFilmler.document().set(f6)*/


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }
}