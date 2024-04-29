package com.firstapp.giris.nesne_tabanli_programlama

class Odev2 {
    fun mile(km:Double) : Double{
        val mile = km * 0.621
        return mile
    }

    fun dikdortgenAlan(uzun:Int,kisa:Int)
    {
        val sonuc = uzun * kisa
        println("dikdörtgenin Alanı: $sonuc")
    }

    fun faktoriyel(num:Int) : Int {
        if( num <= 1 )
        {
            return 1
        }
        else
        {
            return num * faktoriyel(num -1)
        }
    }

    fun eHarfiSayisi(kelime:String) : Int{
        var eSayisi = 0

        for (harf in kelime)
        {
            if (harf == 'e')
            {
                eSayisi++
            }
        }
        return eSayisi
    }
}