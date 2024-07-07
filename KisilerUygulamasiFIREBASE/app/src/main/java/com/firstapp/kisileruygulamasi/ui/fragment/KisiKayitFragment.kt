package com.firstapp.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.firstapp.kisileruygulamasi.R
import com.firstapp.kisileruygulamasi.databinding.FragmentKisiDetayBinding
import com.firstapp.kisileruygulamasi.databinding.FragmentKisiKayitBinding
import com.firstapp.kisileruygulamasi.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiKayitFragment : Fragment() {
    private lateinit var binding: FragmentKisiKayitBinding
    private lateinit var viewmodel: KisiKayitViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_kayit, container,false)
        binding.kisiKayitFragment = this //Bunu tanımlamazsak tanımlar boş kalır
        binding.kisiKayitToolbarBaslik= "Kişi Kayıt"

        binding.buttonKaydet.setOnClickListener {
            val kisi_ad = binding.editTextkisiAd.text.toString()
            val kisi_tel = binding.editTextKisiTel.text.toString()

            buttonKaydet(kisi_ad,kisi_tel)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:KisiKayitViewModel by viewModels()
        viewmodel = tempViewModel
    }

    fun buttonKaydet(kisi_ad:String,kisi_tel:String)
    {
        viewmodel.kaydet(kisi_ad,kisi_tel)
    }
}