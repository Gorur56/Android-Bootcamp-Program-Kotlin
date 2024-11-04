package com.example.kotlinalgoritmasorulari

fun main() {
    println("Bir sayı giriniz: ")
    val userInput = readLine()?.toIntOrNull()
    if( userInput != null) {
        if( isPolindromeNumber(userInput) ) {
            println("Girdiğiniz sayı polindromdur.")
        } else {
            println("Girdiğiniz sayı polindrom değildir.")
        }
    }
}

fun isPolindromeNumber(number: Int): Boolean {
    val numberStr = number.toString()
    return numberStr == numberStr.reversed()
}

fun isPalindromeNumber(number: Int): Boolean {
    val numberStr = number.toString() // Sayıyı stringe çevir
    val length = numberStr.length

    for (i in 0 until length / 2) {
        if (numberStr[i] != numberStr[length - i - 1]) {
            return false // Eğer herhangi bir karakter tersindekiyle uyuşmazsa palindrom değil
        }
    }
    return true // Tüm karakterler eşleşirse palindromdur
}