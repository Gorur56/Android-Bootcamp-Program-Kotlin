package com.example.notlaruygulamasdesign

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.notlaruygulamasdesign.databinding.ActivityDetayBinding
import com.example.notlaruygulamasdesign.databinding.ActivityNotKayitBinding

class DetayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.detayActivityToolbarTitle = "Not Detay"
        setSupportActionBar(binding.toolbarDetay)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //toolbar menu dosyasını aktarma
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Tıklanan item 'ı verir.

        when(item.itemId){
            R.id.action_sil -> {
                return true
            }

            R.id.action_duzenle -> {
                return true
            }

            else -> return false
        }
    }
}