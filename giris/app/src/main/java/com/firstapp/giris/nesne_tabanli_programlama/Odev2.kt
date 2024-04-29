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

    fun sumEdge(kenarSayisi:Int) : Int{
        val sonuc = ((kenarSayisi - 2) * 180) / kenarSayisi
        return sonuc
    }

    fun maasHesapla(gun:Int) : Int{
        val toplamSaat = gun * 8;

        var mesai = 0;

        var maas = 0

        if( toplamSaat <= 150)
        {
            maas = toplamSaat * 40;
            return maas
        }

        mesai = toplamSaat - 150
        maas = ( 150 * 40 ) + (mesai * 80)
        return maas
    }

    fun otoparkUcreti( saat:Int) : Int
    {
        var ucret = 50
        if ( saat == 1)
        {
            return ucret
        }
        else
        {
            ucret += (saat - 1) * 10
            return ucret
        }
    }
}