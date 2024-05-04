package com.firstapp.navigationcomponentkullanimi

import java.io.Serializable

data class Urunler(var id:Int, var ad:String) : Serializable{

    //Serializable : Eklemezsek veri transferini gerçekleştiremeyiz. Nav dosyasında Urunler sınıfını göremeyiz.

}