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