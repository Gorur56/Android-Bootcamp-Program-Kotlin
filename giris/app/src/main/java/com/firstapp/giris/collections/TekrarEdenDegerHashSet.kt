package com.firstapp.giris.collections

fun main() {
    val dizi = intArrayOf(1,2,3,2,4,5)
    println(hashSetDuplicate(dizi))
}

fun hashSetDuplicate(nums:IntArray): Boolean{
    val set = HashSet<Int>()

    for(num in nums)
    {
        if(set.contains(num))
        {
            return true
        }
        else
        {
            set.add(num)
        }
    }

    return false
}