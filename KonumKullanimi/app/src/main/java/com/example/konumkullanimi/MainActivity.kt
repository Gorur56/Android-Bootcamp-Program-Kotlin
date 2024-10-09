package com.example.konumkullanimi

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.konumkullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var izinKontrol = 0
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

        binding.buttonKonumAl.setOnClickListener {
            //Lokasyon izin onaylandı mı kontol et.
            //Bunu manifest dosyasındaki     <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/> yapıyor.

            //Manifest = android olanı seç
            izinKontrol = ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)

            if( izinKontrol == PackageManager.PERMISSION_GRANTED) { //İzin onaylanmışsa

            }else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 100)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //Gelen request 'i buradan alacağız.
        if( requestCode == 100 ) {
            //grantResults arrayOf içindeki izinleri simgeler
            if( grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //Onaylandıysa toast mesajı ver
                Toast.makeText(applicationContext,"İzin onaylandı.",Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(applicationContext,"İzin onaylanmadı.",Toast.LENGTH_SHORT).show()
            }
        }
    }
}