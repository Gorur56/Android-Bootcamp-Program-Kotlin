package com.example.kotlinalgoritmasorulari

fun main() {
    val numbs = listOf(4, 3, 2, 4, 1, 3, 2)
    println(findDuplicate(numbs))
}

fun findDuplicate(numbs: List<Int>): Int? {
    val seen = mutableSetOf<Int>()
    for ( num in numbs ) {
        if ( num in seen ) return num
        seen.add(num)
    }
    return null
}

