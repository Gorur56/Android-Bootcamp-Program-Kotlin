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
import com.example.sozlukuygulamasi.data.KelimelerCevap
import com.example.sozlukuygulamasi.retrofit.ApiUtils
import com.example.sozlukuygulamasi.retrofit.KelimelerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var kelimelerListe:ArrayList<Kelimeler>
    private lateinit var adapter:KelimlerAdapter

    private lateinit var kdi:KelimelerDaoInterface
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

        kdi = ApiUtils.getKelimelerDaoInterface()

        tumKelimeler()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu?.findItem(R.id.action_ara)
        val searchView = item?.actionView as SearchView

        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        //Arama tuşuna basınca search yapar.
        if (query != null) {
            aramaYap(query)
            Log.e("Gönderilen Arama",query)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        //Her girilen harf için search yapar.
        if (newText != null) {
            aramaYap(newText)
            Log.e("Harf girdikce", newText)
        }
        return true
    }

    fun tumKelimeler(){
        kdi.tumKelimeler().enqueue(object : Callback<KelimelerCevap>{
            override fun onResponse(call: Call<KelimelerCevap>, response: Response<KelimelerCevap>) {

                if( response != null)
                {
                    val liste = response.body()?.kelimeler
                    adapter = liste?.let { KelimlerAdapter(this@MainActivity, it) }!!
                    rv.adapter = adapter
                }
            }

            override fun onFailure(call: Call<KelimelerCevap>, t: Throwable) {

            }
        })
    }

    fun aramaYap(aramaKelimle: String){
        kdi.kelimeAra(aramaKelimle).enqueue(object : Callback<KelimelerCevap> {
            override fun onResponse(call: Call<KelimelerCevap>, response: Response<KelimelerCevap>) {
                if(response != null) {
                    val liste = response.body()?.kelimeler
                    adapter = liste?.let { KelimlerAdapter(this@MainActivity,it) }!!
                    rv.adapter = adapter
                }
            }

            override fun onFailure(call: Call<KelimelerCevap>, t: Throwable) {

            }
        })
    }
}