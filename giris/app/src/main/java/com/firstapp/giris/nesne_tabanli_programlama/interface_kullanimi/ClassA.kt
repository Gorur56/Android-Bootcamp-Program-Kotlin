package com.firstapp.giris.nesne_tabanli_programlama.interface_kullanimi

class ClassA : MyInterface, MyInterface2 {
    //Kalıtımda "()" koyuyoruz. Interface 'de koymuyoruz.
    //interface eklediğimiz zaman bütün yapıları aktarmak zorundayız yoksa hata alırız.
    //Bir sınıfa sadece bir sınıf aktarabiliyorken, birden fazla interface 'i sınıfa aktarabiliriz.
    override val degisken: Int = 10

    override fun method1() {
        println("Method1 Çalıştı...")
    }

    override fun method2():String{
        return "Method2 çalıştı."
    }

    override val degisken2: Int = 20

    override fun method3() {
        println("Method 3 Çalıştı..")
    }

    override fun method4(): String {
        return "Method 4 çalıştı..."
    }
}