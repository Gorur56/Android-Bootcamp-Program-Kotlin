package com.firstapp.navigationcomponentkullanimi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.firstapp.navigationcomponentkullanimi.databinding.ActivityMainBinding
import com.firstapp.navigationcomponentkullanimi.databinding.FragmentAyarlarBinding

class MainActivity : AppCompatActivity() {

    //Fragment 'ları bir activity üzerinde oluşturuyoruz. Activity olmadan Fragment oluşturamayız.
    //Fragment 'alr sayfa geçişini daha görsel ve pratik hale getirir.
    //Geçişlerde veri transferi ve animasyon ekleyebiliriz.

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root) //Binding çevirme
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val navHostFragment1 = supportFragmentManager.findFragmentById(R.id.navHostFragment1) as NavHostFragment

        //Bottom 'a erişiyoruz. navHostFragment1 ile birleştiriyoruz.
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navHostFragment1.navController)
    }
}