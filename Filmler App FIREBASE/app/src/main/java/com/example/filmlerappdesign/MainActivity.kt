package com.example.filmlerappdesign

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmlerappdesign.adapter.KategoriAdapter
import com.example.filmlerappdesign.entity.Kategoriler
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    private lateinit var kategoriList:ArrayList<Kategoriler>
    private lateinit var adapter:KategoriAdapter
    private lateinit var refKategoriler:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var toolbarKategori: Toolbar = findViewById(R.id.toolbarKategori)
        toolbarKategori.title = "Kategoriler"
        setSupportActionBar(toolbarKategori)

        var kagetoriRV: RecyclerView = findViewById(R.id.kagetoriRV)

        kagetoriRV.setHasFixedSize(true)
        kagetoriRV.layoutManager = LinearLayoutManager(this) //Alt Alta gösterir.


        val db = FirebaseDatabase.getInstance()
        refKategoriler = db.getReference("kategoriler")

        kategoriList = ArrayList()

        adapter = KategoriAdapter(this,kategoriList)
        kagetoriRV.adapter = adapter

        tumKategoriler()
    }

    private fun tumKategoriler(){
        refKategoriler.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(d: DataSnapshot) {
                kategoriList.clear()

                for(c in d.children){
                    val categorise = c.getValue(Kategoriler::class.java)
                    if( categorise != null)
                    {
                        categorise.kategori_id = c.key
                        kategoriList.add(categorise)
                    }
                }

                adapter.notifyDataSetChanged() //Arayüzü günceller
            }

            override fun onCancelled(error: DatabaseError) {
                //Hata aldığında çalışan blok
            }
        })
    }
}