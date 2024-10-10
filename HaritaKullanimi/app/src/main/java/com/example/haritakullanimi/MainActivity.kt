package com.example.haritakullanimi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.haritakullanimi.databinding.ActivityMainBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() , OnMapReadyCallback {
   //OnMapReadyCallback=> harita erişimi için eklenmesi gerekiyor.
    private lateinit var binding: ActivityMainBinding
    private lateinit var mMap:GoogleMap
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

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.buttonKonumaGit.setOnClickListener {
            //41.0370018,28.9850917 taksim
            val konum = LatLng(41.0370018, 28.9850917)
            mMap.addMarker(MarkerOptions().position(konum)
                .title("Taksim")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.resim))) //Harita imlecinin ikonunu değiştirdik.

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(konum, 15f))
            mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE //Uydu görünümüne çevirir
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        //40.9332536,29.1639831
        val konum = LatLng(40.9332536, 29.1639831)
        mMap.addMarker(MarkerOptions().position(konum).title("İstanbul"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(konum))
    }
}