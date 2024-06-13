package com.firstapp.kisileruygulamasi.data.entity

data class KisilerCevap(var kisiler:List<Kisiler>,
                        var success:Int) {
    // tum_kişiler Ve tum_kisiler_arama webservis cevabını buradan ve Kisiler sınıfından alacağız.
}