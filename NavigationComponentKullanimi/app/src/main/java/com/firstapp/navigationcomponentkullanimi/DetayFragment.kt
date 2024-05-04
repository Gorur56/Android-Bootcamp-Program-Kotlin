package com.firstapp.navigationcomponentkullanimi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.firstapp.navigationcomponentkullanimi.databinding.FragmentAnasayfaBinding
import com.firstapp.navigationcomponentkullanimi.databinding.FragmentDetayBinding

class DetayFragment : Fragment() {
    private lateinit var binding:FragmentDetayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetayBinding.inflate(inflater, container, false)

        binding.textViewBilgi.text = "Merhaba"
        return binding.root
    }
}