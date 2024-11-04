package com.example.animasyonlufabbutonlari

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.animasyonlufabbutonlari.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    var fabDurum = false
    private lateinit var binding: ActivityMainBinding
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

        //Program çalıştığında tek bir fab görünsün istiyorum.
        binding.fabBirinci.scaleX = 0.0f // görümez yap
        binding.fabBirinci.scaleY = 0.0f

        binding.fabIkinci.scaleX = 0.0f // görümez yap
        binding.fabIkinci.scaleY = 0.0f




        binding.fabMain.setOnClickListener {
            if(fabDurum) {
                val rotateFabMain = ObjectAnimator.ofFloat(binding.fabMain,"rotation",45.0f,0.0f)
                val scaleXFabBirinci = ObjectAnimator.ofFloat(binding.fabBirinci,"ScaleX",1.0f,0.0f)
                val scaleYFabBirinci = ObjectAnimator.ofFloat(binding.fabBirinci, "ScaleY", 1.0f,0.0f)

                val scaleXFabIkinci = ObjectAnimator.ofFloat(binding.fabIkinci,"ScaleX",1.0f,0.0f)
                val scaleYFabIkinci = ObjectAnimator.ofFloat(binding.fabIkinci, "ScaleY", 1.0f,0.0f)

                val cokluAnimasyon = AnimatorSet().apply {
                    duration = 500
                    playTogether(rotateFabMain,scaleXFabBirinci,scaleYFabBirinci,scaleXFabIkinci, scaleYFabIkinci)
                }
                cokluAnimasyon.start()
                fabDurum =  false

            }else {
                val rotateFabMain = ObjectAnimator.ofFloat(binding.fabMain,"rotation",0.0f,45.0f)
                val scaleXFabBirinci = ObjectAnimator.ofFloat(binding.fabBirinci,"ScaleX",0.0f,1.0f)
                val scaleYFabBirinci = ObjectAnimator.ofFloat(binding.fabBirinci, "ScaleY", 0.0f,1.0f)

                val scaleXFabIkinci = ObjectAnimator.ofFloat(binding.fabIkinci,"ScaleX",0.0f,1.0f)
                val scaleYFabIkinci = ObjectAnimator.ofFloat(binding.fabIkinci, "ScaleY", 0.0f,1.0f)

                val cokluAnimasyon = AnimatorSet().apply {
                    duration = 500
                    playTogether(rotateFabMain,scaleXFabBirinci,scaleYFabBirinci,scaleXFabIkinci, scaleYFabIkinci)
                }
                cokluAnimasyon.start()
                fabDurum =  true
            }
        }

        binding.fabBirinci.setOnClickListener {
            Snackbar.make(it,"Merhaba ben Birinci FAB", Snackbar.LENGTH_SHORT).show()
        }

        binding.fabIkinci.setOnClickListener {
            Snackbar.make(it,"Merhaba ben İkinci FAB", Snackbar.LENGTH_SHORT).show()
        }

    }
}