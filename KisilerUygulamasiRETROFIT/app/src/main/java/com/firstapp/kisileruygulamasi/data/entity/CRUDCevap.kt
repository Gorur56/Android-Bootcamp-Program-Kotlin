package com.firstapp.kisileruygulamasi.data.entity

import android.os.Message

data class CRUDCevap(var success:Int,
                     var message:String) {
    //Burayı ilk JSON formatı için oluşturduk.
    //İkinci JSON formatına uyan Kisiler Class 'mız var zaten bu yüzden oluşturmamızı gerek yok.

    //CRUD: creeate, read, update, delete işlemlerini burada yappacağız.
}