package com.example.filmlerapp.retrofit

class ApiUtils {
    companion object{//static
        val base_URL = "http://kasimadalan.pe.hu/"

        fun getFilmlerDao() : FilmlerDao {
            return RetrofitClient.getClient(base_URL).create(FilmlerDao::class.java)
        }
    }
}