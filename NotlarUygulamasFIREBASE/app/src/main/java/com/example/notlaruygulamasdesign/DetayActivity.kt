package com.example.notlaruygulamasdesign

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.notlaruygulamasdesign.data.Notlar
import com.example.notlaruygulamasdesign.databinding.ActivityDetayBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DetayActivity : AppCompatActivity() {
    private lateinit var not:Notlar
    private lateinit var refNotlar: DatabaseReference
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

        val db = FirebaseDatabase.getInstance()
        refNotlar = db.getReference("notlar")

        not = intent.getSerializableExtra("nesne") as Notlar

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
                        refNotlar.child(not.not_id!!).removeValue()
                        startActivity(Intent(this@DetayActivity,MainActivity::class.java))
                        finish()
                    }.show()

                return true
            }

            R.id.action_duzenle -> {
                val ders_adi = binding.editTextDersDetay.text.toString().trim()
                val not1 = binding.editTextNot1Detay.text.toString().trim()
                val not2 = binding.editTextNot2Detay.text.toString().trim()

                if( TextUtils.isEmpty(ders_adi)) {
                   Snackbar.make(binding.toolbarDetay,"Ders adını giriniz.", Snackbar.LENGTH_SHORT).show()
                   return false
                }

                if( TextUtils.isEmpty(not1)) {
                    Snackbar.make(binding.toolbarDetay,"1. Notu giriniz.", Snackbar.LENGTH_SHORT).show()
                    return false
                }

                if( TextUtils.isEmpty(not2)) {
                    Snackbar.make(binding.toolbarDetay,"2. Notu giriniz.", Snackbar.LENGTH_SHORT).show()
                    return false
                }

                val bilgiler = HashMap<String,Any>()
                bilgiler.put("ders_adi",ders_adi)
                bilgiler.put("not1",not1.toInt())
                bilgiler.put("not2",not2.toInt())

                refNotlar.child(not.not_id!!).updateChildren(bilgiler) //güncelle

                startActivity(Intent(this@DetayActivity,MainActivity::class.java))
                finish()
                return true
            }

            else -> return false
        }
    }
}