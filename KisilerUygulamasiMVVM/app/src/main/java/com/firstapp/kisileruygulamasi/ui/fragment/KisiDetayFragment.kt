package com.firstapp.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.firstapp.kisileruygulamasi.R
import com.firstapp.kisileruygulamasi.databinding.FragmentKisiDetayBinding

class KisiDetayFragment : Fragment() {
    private lateinit var binding: FragmentKisiDetayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentKisiDetayBinding.inflate(inflater, container, false)

        binding.toolbarKisiDetay.title = "Kişi Detay"

        //Gönderilen verileri alan sınıf Args oluyor.
        val bundle:KisiDetayFragmentArgs by navArgs()

        val gelenKisi = bundle.kisi

        //Edittextlere gelen kişileri yazma
        binding.editTextKisiDetayAd.setText(gelenKisi.kisi_ad)
        binding.editTextKisiDetayTel.setText(gelenKisi.kisi_tel)

        binding.buttonGuncelle.setOnClickListener {
            val kisi_ad = binding.editTextKisiDetayAd.text.toString()
            val kisi_tel = binding.editTextKisiDetayTel.text.toString()

            buttonGuncelle(gelenKisi.kisi_id, kisi_ad,kisi_tel)
        }
        return binding.root
    }

    fun buttonGuncelle(kisi_id:Int, kisi_ad:String, kisi_tel:String)
    {
        Log.e("Kişi Güncelle: ", "$kisi_id - $kisi_ad - $kisi_tel")
    }
}