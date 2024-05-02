package com.firstapp.giris.ilerikotlin

fun main() {
    //Compile Error : Derlemeden yazarken verilen hatalardır.
    val x = 10
    //x = 300 //Val olduğu için hata verir.
    //Exception: Runtime Error //Uygulamayı çökerten yapılar. Çalıştırma sırasında verilen hatalardır.

    val a = 20
    val b = 0 //Exception in thread "main" java.lang.ArithmeticException: / by zero hatası verir

   //println("Sonuç : ${a/b}")
    println("işlem tamam")

    try {
        println("Sonuç : ${a/b}")
        println("işlem tamam")
    }catch (e:Exception)
    {
        println("Bir sayıyı sıfıra bölemezsiniz.")
    }
}