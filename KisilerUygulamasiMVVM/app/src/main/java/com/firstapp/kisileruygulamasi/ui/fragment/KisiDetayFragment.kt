package com.firstapp.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.firstapp.kisileruygulamasi.R
import com.firstapp.kisileruygulamasi.databinding.FragmentKisiDetayBinding
import com.firstapp.kisileruygulamasi.ui.viewmodel.KisiDetayViewModel

class KisiDetayFragment : Fragment() {
    private lateinit var binding: FragmentKisiDetayBinding
    private lateinit var viewmodel: KisiDetayViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay, container, false)
        binding.kisiDetayFragment = this
        binding.kisiDetayToolbarBaslik = "Kişi Detay"

        //Gönderilen verileri alan sınıf Args oluyor.
        val bundle:KisiDetayFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi

        binding.kisiNesnesi = gelenKisi
        return binding.root
    }

    fun buttonGuncelle(kisi_id:Int, kisi_ad:String, kisi_tel:String)
    {
        Log.e("Kişi Güncelle: ", "$kisi_id - $kisi_ad - $kisi_tel")
    }
}