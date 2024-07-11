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

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var notlarListe: ArrayList<Notlar>
    private lateinit var adapter: NotlarAdapter
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
        binding.toolbar.subtitle = "Ortalama: 60"
        setSupportActionBar(binding.toolbar)


        val rv: RecyclerView = findViewById(R.id.rv)
        rv.setHasFixedSize(true)

        //Alt Alta görünmesi için
        rv.layoutManager = LinearLayoutManager(this)

        notlarListe = ArrayList()

        val n1 = Notlar(1,"Tarih",40,80)
        val n2 = Notlar(2,"Kimya",70,50)
        val n3 = Notlar(3,"Fizik",30,60)

        notlarListe.add(n1)
        notlarListe.add(n2)
        notlarListe.add(n3)

        adapter = NotlarAdapter(this,notlarListe)
        rv.adapter = adapter
        binding.fab.setOnClickListener{
            startActivity(Intent(this@MainActivity,NotKayitActivity::class.java))
        }
    }

    override fun onBackPressed() {
        //Farklı sayfalar ana sayfaya geçince ana sayfa birden fazla açılır.
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}