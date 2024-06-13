package com.firstapp.kisileruygulamasi.retrofit

class ApiUtils {
    //Interface 'e erişim sağlar
    companion object{//static
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getKisilerDao() : KisilerDao{
            //Interface 'e erişip oradaki fonksiyonu çalıştırıyoruz
            return RetrofitClient.getClient(BASE_URL).create(KisilerDao::class.java)
        }
    }
}