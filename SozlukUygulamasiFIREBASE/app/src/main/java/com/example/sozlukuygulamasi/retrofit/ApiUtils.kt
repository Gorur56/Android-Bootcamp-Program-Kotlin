package com.example.sozlukuygulamasi.retrofit

class ApiUtils {

    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getKelimelerDaoInterface(): KelimelerDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(KelimelerDaoInterface::class.java)
        }
    }
}