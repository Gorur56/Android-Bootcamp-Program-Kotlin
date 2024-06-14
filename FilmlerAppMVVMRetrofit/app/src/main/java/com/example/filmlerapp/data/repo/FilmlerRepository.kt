package com.example.filmlerapp.data.repo

import com.example.filmlerapp.data.datasource.FilmlerDataSource
import com.example.filmlerapp.data.entity.Filmler
import dagger.hilt.android.lifecycle.HiltViewModel

class FilmlerRepository(var fds:FilmlerDataSource){
    //var fds = FilmlerDataSource()
    suspend fun filmleriYukle() : List<Filmler> = fds.filmleriYukle()

}