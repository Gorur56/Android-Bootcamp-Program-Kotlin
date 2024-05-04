package com.firstapp.navigationcomponentkullanimi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.window.OnBackAnimationCallback
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.navArgs
import com.firstapp.navigationcomponentkullanimi.databinding.FragmentAnasayfaBinding
import com.firstapp.navigationcomponentkullanimi.databinding.FragmentDetayBinding
import com.google.android.material.snackbar.Snackbar

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

        //Back tuşunu devre dışı bırakmak
        val backPress = object : OnBackPressedCallback(true){ //true back tuşunu devredıiı bırakır.
            override fun handleOnBackPressed() {
                //Bunu false yaparsak çalışır.
                Snackbar.make(binding.textViewBilgi,"Geri Dönmek istiyor musun?", Snackbar.LENGTH_SHORT)
                    .setAction("EVET"){
                        //Evet ise back tuşuna basarken işlem yaptırabiliriz.
                        isEnabled = false //Geri dönüş aktif
                        requireActivity().onBackPressedDispatcher.onBackPressed()
                    }
                    .show()

            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,backPress)
        return binding.root
    }
}