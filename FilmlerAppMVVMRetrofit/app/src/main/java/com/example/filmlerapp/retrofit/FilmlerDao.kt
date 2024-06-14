package com.example.filmlerapp.retrofit

import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.data.entity.FilmlerCevap
import retrofit2.http.GET

interface FilmlerDao {

    //http://kasimadalan.pe.hu/filmler_yeni/resimler/django.png
    //http://kasimadalan.pe.hu/filmler_yeni/tum_filmler.php
    //base url -> http://kasimadalan.pe.hu/
    //web servis url -> filmler_yeni/tum_filmler.php

    @GET("filmler_yeni/tum_filmler.php")
    suspend fun filmleriYukle() : FilmlerCevap
}