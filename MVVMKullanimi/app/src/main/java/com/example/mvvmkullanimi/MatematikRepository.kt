package com.example.mvvmkullanimi

class MatematikRepository {
    //Repostory 'nin ilk görevi DataSource Erişmektir.
    //Veriyi dataSource 'dan alır ve ViewModel 'e iletir.
    var mds = MatematikDataSource()

    //Tek satır return ise aşağıdaki gibi de yazabiliriz.
    suspend fun toplamaYap(alinanSayi1:String, alinanSayi2: String) : String = mds.toplamaYap(alinanSayi1,alinanSayi2)

    suspend fun carpmaYap(alinanSayi1:String, alinanSayi2: String) : String {
        return mds.carpmaYap(alinanSayi1,alinanSayi2)
    }
}