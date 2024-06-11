package com.example.preferencesdatastorekullanimi

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.preferencesdatastorekullanimi.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ap = AppPref(this)

        CoroutineScope(Dispatchers.Main).launch {
            //Kayıt işlemleri
            ap.kayitAd("Ahmet")

            //Yukarıdaki satırın bir defa çalışması yeterli ahmet ismini hatırlayacaktır.
            //Bu şekilde silebilirsiz. Veya Uygulamayı silersekte silinir.
            ap.silAd()

            //okuma İşlemleri
            val gelenAdd = ap.okuAd()
            Log.e("Gelen Ad",gelenAdd) //İsim yok

            //Kayıt işlemi
            ap.kayitAd("Mehmet")
            ap.kayitYas(20)
            ap.kayitBoy(1.80)
            ap.kayitBekar(true)

            val liste = HashSet<String>()
            liste.add("Ali")
            liste.add("Ece")
            ap.kayitArkadasListe(liste)

            //Okuma İşlemi
            val gelenAd = ap.okuAd()
            val gelenYas = ap.okuYas()
            val gelenBoy = ap.okuBoy()
            val gelenBekar = ap.okuBekar()

            Log.e("Gelen Ad",gelenAd)
            Log.e("Gelen Yas",gelenYas.toString())
            Log.e("Gelen Boy",gelenBoy.toString())
            Log.e("Gelen Bekar durum",gelenBekar.toString())

            val gelenListe = ap.okuArkadasListe()

            if(gelenListe != null)
            {
                for (a in gelenListe)
                {
                    Log.e("Gelen Liste",a)
                }
            }

        }
    }
}