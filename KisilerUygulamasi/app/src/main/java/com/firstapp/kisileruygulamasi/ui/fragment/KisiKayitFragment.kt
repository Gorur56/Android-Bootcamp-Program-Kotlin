package com.firstapp.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.firstapp.kisileruygulamasi.R
import com.firstapp.kisileruygulamasi.databinding.FragmentKisiDetayBinding
import com.firstapp.kisileruygulamasi.databinding.FragmentKisiKayitBinding

class KisiKayitFragment : Fragment() {
    private lateinit var binding: FragmentKisiKayitBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentKisiKayitBinding.inflate(inflater,container,false)

        binding.toolbarKisiKayit.title = "Kişi Kayıt"

        binding.buttonKaydet.setOnClickListener {
            val kisi_ad = binding.editTextkisiAd.text.toString()
            val kisi_tel = binding.editTextKisiTel.text.toString()

            kaydet(kisi_ad,kisi_tel)
        }
        return binding.root
    }

    fun kaydet(kisi_ad:String,kisi_tel:String)
    {
        Log.e("Kişi Kaydet", "$kisi_ad - $kisi_tel")
    }
}