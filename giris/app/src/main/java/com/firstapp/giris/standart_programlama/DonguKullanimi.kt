package com.firstapp.giris.standart_programlama

fun main(){
    //1,2,3 3 defa dönecek döngü

    for (i in 1..3){ //swift i in 1...3
        println("Döngü: $i")
    }

    println()

    //10 ile 20 arasında 5 ' er artsın
    for (a in 10..20 step 5)
    {
        println("Artan döngü + 5: $a")
    }

    println()

    //10 ile 20 arasında 5 ' er azalsın
    for(b in 20 downTo 10 step 5)
    {
        println("Azalan döngü: $b")
    }

}