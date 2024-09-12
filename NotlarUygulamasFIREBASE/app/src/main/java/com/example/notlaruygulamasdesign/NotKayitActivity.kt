package com.example.notlaruygulamasdesign

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.notlaruygulamasdesign.data.Notlar
import com.example.notlaruygulamasdesign.databinding.ActivityMainBinding
import com.example.notlaruygulamasdesign.databinding.ActivityNotKayitBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class NotKayitActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotKayitBinding
    private lateinit var refNotlar: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityNotKayitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.notKayitActivityToolbarTitle = "Not Kayıt"
        setSupportActionBar(binding.toolbarNotKayit)

        val db = FirebaseDatabase.getInstance()
        refNotlar = db.getReference("notlar")

        binding.buttonKaydet.setOnClickListener {
            //trim beyaz boşlukları alır
            val ders_adi = binding.editTextDers.text.toString().trim()
            val not1 = binding.editTextNot1.text.toString().trim()
            val not2 = binding.editTextNot2.text.toString().trim()

            //Ders adı, not1 veya not2 boşsa uyarı ver
            if( TextUtils.isEmpty(ders_adi)) {
                //uyarı ver kodu durdur
                Snackbar.make(binding.toolbarNotKayit,"Ders adını giriniz.", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if ( TextUtils.isEmpty(not1)){
                Snackbar.make(binding.toolbarNotKayit, "1. notu giriniz.", Snackbar.LENGTH_SHORT ).show()
                return@setOnClickListener
            }

            if ( TextUtils.isEmpty(not2)){
                Snackbar.make(binding.toolbarNotKayit, "2. Notu giriniz.", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //Yukarıdaki koşulalr sağlanıyorsa. Database 'e not kaydedebiliriz.
            val not = Notlar("", ders_adi, not1.toInt(), not2.toInt())
            refNotlar.push().setValue(not)

            startActivity(Intent(this@NotKayitActivity, MainActivity::class.java))
            finish()
        }
    }
}