package com.firstapp.kisileruygulamasi.data.entity

import java.io.Serializable

data class Kisiler( var kisi_id:Int,
                    var kisi_ad:String,
                    var kisi_tel:String) : Serializable {

    /* JSON FORMATI
    {"kisiler":[{"kisi_id":"15674","kisi_ad":"Ahmet","kisi_tel":"3333"},
    {"kisi_id":"16169","kisi_ad":"x","kisi_tel":"y"}],"success":1}

    VERİ ÇIKIŞI

    {
       "kisiler":[
          {
             "kisi_id":"15674",
             "kisi_ad":"Ahmet",
             "kisi_tel":"3333"
          },
          {
             "kisi_id":"16169",
             "kisi_ad":"x",
             "kisi_tel":"y"
          }
       ],
       "success":1
    }*/

}