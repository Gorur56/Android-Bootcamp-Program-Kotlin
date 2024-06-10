package com.example.filmlerapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.filmlerapp.data.repo.FilmlerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnasayfaViewModel : ViewModel() {
    var frepo = FilmlerRepository()

    fun filmleriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            frepo.filmleriYukle()
        }
    }
}