package com.firstapp.kullanicietkilesimitoastsnackbardialog

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.firstapp.kullanicietkilesimitoastsnackbardialog.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Toast Kullanımı
        binding.buttonToast.setOnClickListener {
            //Eski bir yapısır.
            //Snackbar ve Dialog daha çok kullanılıyor.
            Toast.makeText(this,"Merhaba",Toast.LENGTH_SHORT ).show()
        }

        // Snackbar Kullanımı
        binding.buttonSnackBar.setOnClickListener {
            Snackbar.make(it, "Silmek istiyor musunuz?", Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                    Snackbar.make(it, "Silindi.",Snackbar.LENGTH_SHORT)
                        .setBackgroundTint(Color.WHITE)
                        .setTextColor(Color.BLUE)
                        .show()
                }
                .setBackgroundTint(Color.WHITE) //Arkaplan rengi
                .setTextColor(Color.RED) //Yazı rengi
                .show()
        }

        // Dialog Kullanımı: Sayfa üzerinde açılıp biz seçim yapana kadar bekler.
        //Pozitif ve negatif butonları vardır.
        binding.buttonDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this@MainActivity)
                .setTitle("Başlık")
                .setMessage("Mesaj")
                .setPositiveButton("Tamam"){ yazi,iface->
                    Toast.makeText(this@MainActivity,"Tamam Seçildi", Toast.LENGTH_SHORT).show()
                }

                .setNegativeButton("İptal"){ yazi,iface->
                    Toast.makeText(this@MainActivity,"İptal Seçildi.", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}