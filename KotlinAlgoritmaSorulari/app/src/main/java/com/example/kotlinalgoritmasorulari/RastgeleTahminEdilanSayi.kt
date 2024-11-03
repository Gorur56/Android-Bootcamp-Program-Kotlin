package com.example.kotlinalgoritmasorulari

import kotlin.random.Random

fun main() {
    tahminEt()
}

fun tahminEt(){
    val targetNumber = Random.nextInt(1,100)
    var guess: Int?
    var attempts = 0

    println("1 ile 100 arasında bir sayı tuttum. Bakalım tahmin edebilecek misiniz?")

    while (true) {
        println("Tahmininiz: ")
        guess = readLine()?.toIntOrNull()

        if( guess == null ) {
            println("Lütfen geçerli bir sayı giriniz: ")
            continue
        }

        attempts++

        when {
            guess < targetNumber -> println("Daha büyük bir sayı giriniz.")
            guess > targetNumber -> println("Daha küçük bir sayı giriniz.")
            else -> {
                println("Tebrikler! $attempts denemede tahmin ettiniz.")
                break
            }
        }
    }
    println("Oyun bitti.")
}
