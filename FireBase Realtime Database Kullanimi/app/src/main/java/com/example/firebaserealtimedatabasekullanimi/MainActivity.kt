package com.example.firebaserealtimedatabasekullanimi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.database.FirebaseDatabase
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

        /*//Kişi Kayıt
        val kisi = Kisiler("Sedat",11) //Değer ata
        refKisiler.push().setValue(kisi) // Atanan değerin kaydını oluştur.*/

        /*//Kişi Sil
        refKisiler.child("-O58oa1Xz-CDPn6jJ8sn").removeValue()*/

        /*//Kisi Update
        val updateInfo = HashMap<String, Any>()
        updateInfo["kisi_ad"] = "Yeni Mehmet"
        updateInfo["kisi_yas"] = 100

        refKisiler.child("-O58oLo8T7qN-RRlUiv1").updateChildren(updateInfo)*/

    }
}