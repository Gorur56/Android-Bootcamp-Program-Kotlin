package com.example.filmlerapp.data.datasource

import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.room.FilmlerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmlerDataSource(var fdao:FilmlerDao) {
    suspend fun filmleriYukle() : List<Filmler> =
        withContext(Dispatchers.IO){
            /*Verileri Database 'den alacağız.
            val filmlerListesi = ArrayList<Filmler>()

            val f1 = Filmler(1,"Djongo", "django",24)
            val f2 = Filmler(2,"Interstellar", "interstellar",32)
            val f3 = Filmler(1,"Inception", "inception",16)
            val f4 = Filmler(1,"The Hateful Eight", "thehatefuleight",28)
            val f5 = Filmler(1,"The Pianist", "thepianist",24)
            val f6 = Filmler(1,"Anadoluda", "anadoluda",24)

            filmlerListesi.add(f1)
            filmlerListesi.add(f2)
            filmlerListesi.add(f3)
            filmlerListesi.add(f4)
            filmlerListesi.add(f5)
            filmlerListesi.add(f6)*/

            return@withContext fdao.filmleriYukle()
        }
}