package com.example.filmlerapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.filmlerapp.R
import com.example.filmlerapp.databinding.FragmentAnasayfaBinding
import com.example.filmlerapp.ui.adapter.FilmlerAdapter
import com.example.filmlerapp.ui.viewmodel.AnasayfaViewModel

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container,false)
        binding.anasayfaToolbarBaslik = "Filmler"

        //Aşağıdaki kodu layout 'a taşıdık
        //binding.filmRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        viewModel.filmlerListesi.observe(viewLifecycleOwner){
            val filmlerAdapter = FilmlerAdapter(requireContext(),it)
            // binding.filmRv.adapter = filmlerAdapter layout dosyasına taşındıç
            binding.filmlerAdapter = filmlerAdapter
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:AnasayfaViewModel by viewModels()//Viewmodel 'i direk atayamadığımız için geçici bir değere atıyoruz.
        viewModel = tempViewModel
    }
}