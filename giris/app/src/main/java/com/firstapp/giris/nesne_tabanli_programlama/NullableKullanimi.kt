package com.firstapp.giris.nesne_tabanli_programlama

fun main() {
    //Nullable  - Null safety - Optional(Swift)
    var x = "Merhaba"
    //var x = veya var x:String? gibi değişkenler oluşturamıyorum. null atamamız gerekiyor.

    var str1:String? = null //Şeklinde tanımlayabiliriz. ? 'i nullable olduğunu simgeler

    str1 = "Merhaba"

    //Yöntem1
    //trim() -> önündeki ve arkasındaki boşlukları alır.
    println("Yöntem1: ${str1?.trim()}") //Buradaki ? Eğer str1 null ise uygulamayı çökertmez. null değeri verir.

    //Yöntem2
    println("Yöntem2: ${str1!!}") //!! ben null gelmeyeceğinden eminim çalıştırılabilir demek. Aam null gelirse uygulama çöker.

    str1 = null

    //Yöntem3
    if( str1 != null)
    {
        println("Yöntem3: ${str1}")
    }
    else
    {
        println("Sonuç null 'dur.")
    }

    str1 = "Selam"

    //Yöntem4

    str1?.let {//if koşulu it str1 yerine kullanılabilir.
        println("Yöntem4 :  ${it.trim()}")
    }
}