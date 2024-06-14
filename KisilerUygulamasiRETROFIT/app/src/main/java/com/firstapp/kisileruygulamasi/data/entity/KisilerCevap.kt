package com.firstapp.kisileruygulamasi.data.entity

import java.io.Serializable

data class KisilerCevap(var kisiler:List<Kisiler>,
                        var success:Int) : Serializable {
    // tum_kişiler Ve tum_kisiler_arama webservis cevabını buradan ve Kisiler sınıfından alacağız.
}