package com.firstapp.kisileruygulamasi.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.firstapp.kisileruygulamasi.R

//Extensions: Kendi fonksiyonumuzu veya var olan fonksiyonu geliştirmek istersek kullanırız.

fun Navigation.gecisYap(it:View, id:Int){
    findNavController(it).navigate(id)
}

//Overloading
fun Navigation.gecisYap(it:View, id:NavDirections) {
    findNavController(it).navigate(id)
}