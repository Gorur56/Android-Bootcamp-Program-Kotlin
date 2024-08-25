package com.example.firebaserealtimedatabasekullanimi

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val database = FirebaseDatabase.getInstance() //Firebase 'den yetki alma

        val refKisiler = database.getReference("kisiler") //Tablo oluşturma

        /*
        //KİŞİ KAYIT
        val kisi = Kisiler("Sedat",11) //Değer ata
        refKisiler.push().setValue(kisi) // Atanan değerin kaydını oluştur.*/

        /*
        //KİŞİ SİL
        refKisiler.child("-O58oa1Xz-CDPn6jJ8sn").removeValue()*/

        /*
        //KİŞİ UPDATE
        val updateInfo = HashMap<String, Any>()
        updateInfo["kisi_ad"] = "Yeni Mehmet"
        updateInfo["kisi_yas"] = 100

        refKisiler.child("-O58oLo8T7qN-RRlUiv1").updateChildren(updateInfo)*/

        //VERİ OKUMA

        refKisiler.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(ds: DataSnapshot) {
                //Veri Okuma
                for( p in  ds.children) {
                    val kisi = p.getValue(Kisiler::class.java)

                    if( kisi != null )
                    {
                        val key = p.key
                        Log.e("****************", "******************")
                        Log.e("kisi key", key.toString())
                        kisi.kisi_ad?.let { Log.e("kisi ad", it) }
                        Log.e("kisi yas", (kisi.kisi_yas).toString())
                        Log.e("****************", "******************")


                    }
                }

            }

            override fun onCancelled(error: DatabaseError) {
                //Hata aldığında burası çalışır.
            }
        })

    }
}