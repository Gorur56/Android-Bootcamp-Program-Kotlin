package com.example.notlaruygulamasdesign

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notlaruygulamasdesign.adapter.NotlarAdapter
import com.example.notlaruygulamasdesign.data.Notlar
import com.example.notlaruygulamasdesign.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var notlarListe: ArrayList<Notlar>
    private lateinit var adapter: NotlarAdapter
    private lateinit var refNotlar:DatabaseReference
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

        binding.mainActivityToolbarTitle = "Notlar Uygulaması"
        setSupportActionBar(binding.toolbar)


        val rv: RecyclerView = findViewById(R.id.rv)
        rv.setHasFixedSize(true)
        //Alt Alta görünmesi için
        rv.layoutManager = LinearLayoutManager(this)

        //Firebase 'de notlar tablosuna eriş
        val db = FirebaseDatabase.getInstance()
        refNotlar = db.getReference("notlar")

        notlarListe = ArrayList()

        adapter = NotlarAdapter(this,notlarListe)
        rv.adapter = adapter

        tumNotlar()

        binding.fab.setOnClickListener{
            startActivity(Intent(this@MainActivity,NotKayitActivity::class.java))
        }
    }

    fun tumNotlar(){
        refNotlar.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(d: DataSnapshot) {
                //Firebase her güncellediğinde burası update olacak.
                //Veriileri alıyoruz.
                notlarListe.clear()

                var toplam = 0

                for( c in d.children) {
                    val not = c.getValue(Notlar::class.java)

                    if( not != null) {
                        not.not_id = c.key
                        notlarListe.add(not)
                        toplam += (not.not1!! + not.not2!!)/2
                    }
                }

                //Gelen değerleri arayüzde göster
                adapter.notifyDataSetChanged()

                if( toplam != 0) {
                    binding.toolbar.subtitle = "Ortalama: ${toplam/notlarListe.size}"
                }
            }

            override fun onCancelled(error: DatabaseError) {
                //Hata  aldığında çalışır.
                TODO("Not yet implemented")
            }

        })

    }

    override fun onBackPressed() {
        //Farklı sayfalar ana sayfaya geçince ana sayfa birden fazla açılır.
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}