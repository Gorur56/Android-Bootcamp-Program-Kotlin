package com.firstapp.giris.nesne_tabanli_programlama.paket1

open class A {
    //open => başka sınıf protected 'a erişmek istiyorsa open yapmamız gerekiyor. Kalıtım oluşturuacağım anlamına gelir.
    var varsayilanDegisken = 1

    public var publicDegisken = 2 //Her yerden erişilebilen
    private var privateDegisken = 3 // Sadece bu sınıf kullanabilir
    internal var internalDegisken = 4 //Heryerden erişilebilir.
    protected var protectedDegisken = 5 //Bu sınıf ve kalıtım alan sınıflar kullanabilir.

    //Private 'a erişim olabilmesi için

    fun func(){
        println(privateDegisken)
    }
}