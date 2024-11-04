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

fun isPalindrome(text: String): Boolean { //Birinci yöntem
    val cleanedText = text.replace("\\s".toRegex(),"").lowercase()
    return cleanedText == cleanedText.reversed()
}

fun Palindrome(text: String): Boolean {
    val cleanedText = text.replace("\\s".toRegex(), "").lowercase() // Boşlukları kaldır ve küçük harfe çevir
    val length = cleanedText.length

    for (i in 0 until length / 2) { // İkinci yöntem
        if (cleanedText[i] != cleanedText[length - i - 1]) {
            return false // Eğer herhangi bir karakter tersindekiyle uyuşmazsa palindrom değil
        }
    }
    return true // Tüm karakterler eşleşirse palindromdur
}