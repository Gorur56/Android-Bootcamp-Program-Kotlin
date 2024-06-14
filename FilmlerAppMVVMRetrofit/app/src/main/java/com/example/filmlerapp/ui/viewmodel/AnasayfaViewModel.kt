package com.example.filmlerapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.data.repo.FilmlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var frepo:FilmlerRepository) : ViewModel() {
    //var frepo = FilmlerRepository()

    //Veri aldığımız için LiveData kullanmamız gerekiyor.
    val filmlerListesi = MutableLiveData<List<Filmler>>()

    init {
        //programbaşlayınca listeyi yükler.
        try {
            filmleriYukle()
        }catch (e:Exception) {

        }

    }

    fun filmleriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                filmlerListesi.value = frepo.filmleriYukle()
            }catch (e:Exception){

            }

        }
    }
}