package com.firstapp.navigationcomponentkullanimi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.firstapp.navigationcomponentkullanimi.databinding.FragmentAnasayfaBinding
import com.firstapp.navigationcomponentkullanimi.databinding.FragmentDetayBinding

class DetayFragment : Fragment() {
    private lateinit var binding:FragmentDetayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetayBinding.inflate(inflater, container, false)


        //Verileri Alan sınıf'ın sonunda Args (DetayFragmentArgs) oluyor.
        val bundle:DetayFragmentArgs by navArgs() // navArgs() özelliğini DetayFragmentArgs 'e aktar.

        val gelenAd = bundle.ad
        val gelenYas = bundle.yas
        val gelenBoy = bundle.boy
        val bekar = bundle.bekar

        val urunId = bundle.urun.id
        val urunAd = bundle.urun.ad

        binding.textViewBilgi.text = "$gelenAd - $gelenYas - $gelenBoy - $bekar - $urunId - $urunAd"
        return binding.root
    }
}