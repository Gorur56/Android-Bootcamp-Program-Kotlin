package com.example.notlaruygulamasdesign

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.notlaruygulamasdesign.data.Notlar
import com.example.notlaruygulamasdesign.databinding.ActivityDetayBinding
import com.example.notlaruygulamasdesign.databinding.ActivityNotKayitBinding
import com.google.android.material.snackbar.Snackbar

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

        val not = intent.getSerializableExtra("nesne") as Notlar

        binding.editTextDersDetay.setText(not.ders_adi)
        binding.editTextNot1Detay.setText((not.not1).toString())
        binding.editTextNot2Detay.setText((not.not2).toString())
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
                Snackbar.make(binding.toolbarDetay,"Silinsin mi ?",Snackbar.LENGTH_SHORT)
                    .setAction("EVET")
                    {
                        startActivity(Intent(this@DetayActivity,MainActivity::class.java))
                        finish()
                    }.show()

                return true
            }

            R.id.action_duzenle -> {
                startActivity(Intent(this@DetayActivity,MainActivity::class.java))
                finish()
                return true
            }

            else -> return false
        }
    }
}