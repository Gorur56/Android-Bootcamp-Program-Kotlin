package com.example.sozlukuygulamasi

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sozlukuygulamasi.data.Kelimeler
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var kelimelerListe:ArrayList<Kelimeler>
    private lateinit var adapter:KelimlerAdapter
    private lateinit var  refKelimeler:DatabaseReference

    private lateinit var  rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title = "Sözlük Uygulaması"
        setSupportActionBar(toolbar)

        rv = findViewById(R.id.rv)
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        val db = FirebaseDatabase.getInstance()
        refKelimeler = db.getReference("kelimeler")

        kelimelerListe = ArrayList()

        adapter = KelimlerAdapter(this,kelimelerListe)
        rv.adapter = adapter

        tumKelimler()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu?.findItem(R.id.action_ara)
        val searchView = item?.actionView as SearchView

        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        //Arama tuşuna basınca search yapar.
        aramaYap(query)
        Log.e("Gönderilen Arama",query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        //Her girilen harf için search yapar.
        aramaYap(newText)
        Log.e("Harf girdikce", newText)
        return true
    }

    fun tumKelimler(){
        refKelimeler.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(d: DataSnapshot) {
                kelimelerListe.clear()

                for(c in d.children){
                    val kelime = c.getValue(Kelimeler::class.java)
                    if( kelime != null)
                    {
                        kelime.kelime_id = c.key
                        kelimelerListe.add(kelime)
                    }
                }

                adapter.notifyDataSetChanged() //Arayüzü günceller
            }

            override fun onCancelled(error: DatabaseError) {
                //Hata aldığında çalışan blok
            }
        })
    }

    fun aramaYap(arananKelime:String){
        refKelimeler.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(d: DataSnapshot) {
                kelimelerListe.clear()

                for(c in d.children){
                    val kelime = c.getValue(Kelimeler::class.java)

                    if ( kelime != null)
                    {
                        if( kelime.ingilizce!!.contains(arananKelime))
                        {
                            kelime.kelime_id = c.key
                            kelimelerListe.add(kelime)
                        }
                    }
                }

                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }
}