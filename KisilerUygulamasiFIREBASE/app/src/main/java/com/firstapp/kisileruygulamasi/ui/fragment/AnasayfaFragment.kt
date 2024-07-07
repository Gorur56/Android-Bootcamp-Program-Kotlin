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
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.firstapp.kisileruygulamasi.R
import com.firstapp.kisileruygulamasi.data.entity.Kisiler
import com.firstapp.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.firstapp.kisileruygulamasi.ui.adapter.KisilerAdapter
import com.firstapp.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.firstapp.kisileruygulamasi.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewmodel: AnasayfaViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa,container,false)
        binding.anaSayfaFragment = this
        binding.anasayfaToolbarBaslik = "KİŞİLER"

        viewmodel.kisilerListesi.observe(viewLifecycleOwner){
            //Adapter Nesne Oluştur
            //Bu adapter 'ı recycleView 'e atıyoruz. Yoksa görüntülenme olmaz.
            val kisilerAdapter = KisilerAdapter(requireContext(),it, viewmodel)
            binding.kisilerAdapter = kisilerAdapter
        }


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                //Harf girdikçe veya sildikçe arama yapar
                viewmodel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                //Arama ikonuna basınca bize sonuç getirir.
                viewmodel.ara(query)
                return true
            }

        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:AnasayfaViewModel by viewModels()
        viewmodel = tempViewModel
    }
    fun fabTikla(it:View){
        //Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
        Navigation.gecisYap(it,R.id.kisiKayitGecis) //Extensions
    }
}