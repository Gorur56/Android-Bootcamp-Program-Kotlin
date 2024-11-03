package com.example.kotlinalgoritmasorulari

fun main() {
    println("Bir metin giriniz: ")
    val userInput = readLine() ?: ""

    if( isPalindrome(userInput)) {
        println("Girdiğiniz metin bir palindromdur.")
    } else {
        println("Girdiğiniz değer Polindromdur.")
    }
}

fun isPalindrome(text: String): Boolean {
    val cleanedText = text.replace("\\s".toRegex(),"").lowercase()
    return cleanedText == cleanedText.reversed()
}