package com.example.animasyonislemleri

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.animasyonislemleri.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
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
        //textviewSagdanEkranaGiris()
        //imageSoldanEkranaGiris()

        //buttonAsagidanEkranaGiris()

        binding.button.setOnClickListener {
            //Snackbar.make(it,"Test",Snackbar.LENGTH_SHORT).show()
            //alphaAnimasyon()
            //scaleAnimasyon()
            //rotateAnimasyon()
            //translationAnimasyon()
            //gecikmeOzelligi()
            //ivmeOzelligi()
            //tekrarOzelligi()
            //cokluAnimasyon()
            ardisikAnimasyon()
        }
    }

    fun ardisikAnimasyon() {
        //animasyon özelliklerini sırayla çalıştırır
        val a = ObjectAnimator.ofFloat(binding.imageViewResim, "alpha",1.0f,0.0f)
        val sX = ObjectAnimator.ofFloat(binding.imageViewResim, "scaleX",1.0f,2.0f)
        val sY = ObjectAnimator.ofFloat(binding.imageViewResim, "scaleY",1.0f,3.0f)

        val ardisik = AnimatorSet().apply {
            duration = 1000
            playSequentially(sX,sY,a)
        }
        ardisik.start()
    }

    fun cokluAnimasyon() {
        //Aynı anda bir nesne birden fazla animasyon özellik atanan durumdur.
        val a = ObjectAnimator.ofFloat(binding.imageViewResim, "alpha",1.0f,0.0f)
        val sX = ObjectAnimator.ofFloat(binding.imageViewResim, "scaleX",1.0f,2.0f)
        val sY = ObjectAnimator.ofFloat(binding.imageViewResim, "scaleY",1.0f,3.0f)

        val coklu = AnimatorSet().apply {
            duration = 1000
            playTogether(a,sX,sY)
        }
        coklu.start()
    }

    fun tekrarOzelligi() {
        val t = ObjectAnimator.ofFloat(binding.imageViewResim, "translationY", 0.0f, 100.0f).apply {
            duration = 1000
            repeatCount = ObjectAnimator.INFINITE //Sonsuz tekrarla
            //repeatMode = ObjectAnimator.RESTART //Başlangıça tekrar tekrar döner
            repeatMode = ObjectAnimator.REVERSE //Aşağı yukarı sürekli kaydırır
        }
        t.start()
    }

    fun ivmeOzelligi() {
        val t = ObjectAnimator.ofFloat(binding.imageViewResim,"translationY",0.0f, 300.0f).apply {
            duration = 1000
            //interpolator = OvershootInterpolator() //Dışarı çıkıp içeri doğru geçiş yapar.
            interpolator = BounceInterpolator() //yere düşer gibi bir etki yaratır
        }
        t.start()
    }

    fun gecikmeOzelligi(){
        val t = ObjectAnimator.ofFloat(binding.imageViewResim,"translationY",0.0f,50.0f).apply {
            duration = 3000
            startDelay = 2000 // animasyon 2 saniye gecikmeli başlayacak.
        }
        t.start()
    }

    fun imageSoldanEkranaGiris(){
        val t = ObjectAnimator.ofFloat(binding.imageViewResim,"translationX",-800.0f,0.0f).apply {
            duration = 1000
        }

        t.start()
    }

    fun textviewSagdanEkranaGiris(){
        val t = ObjectAnimator.ofFloat(binding.textViewYazi,"translationX",800.0f,0.0f).apply {
            duration = 1000
        }

        t.start()
    }

    fun buttonAsagidanEkranaGiris(){
        val t = ObjectAnimator.ofFloat(binding.button,"translationY",800.0f,0.0f).apply {
            duration = 1000
        }

        t.start()
    }

    fun translationAnimasyon() {
        val t = ObjectAnimator.ofFloat(binding.textViewYazi, "translationY", 0.0f, -50.0f).apply {
            //translationX 0.0f, 50.0f: yerinden 50 kadar kayar.
            //translationX 0.0f, -50.0f: yerinden tersine 50 kadar kayar.

            //translationY 0.0f, 50.0f: yerinden 50 konum aşağı hareket eder
            //translationY 0.0f, -50.0f: yerinden 50 konum yukarı hareket eder
            duration = 3000
        }
        t.start()
    }

    fun rotateAnimasyon(){
        val r = ObjectAnimator.ofFloat(binding.textViewYazi,"rotation",90.0f,45.0f).apply {
            //45.0f,90.0f: önce 45 'e gelir 45 dan başlar 90 da biter. Saat yönünde
            //90.0f,45.0f: önce 90 a gelir 90 dan başlar 45 de biter. saat yönünün tersinde
            duration = 3000
        }

        r.start()
    }

    fun scaleAnimasyon(){
        val s = ObjectAnimator.ofFloat(binding.imageViewResim,"scaleY",1.0f,0.50f).apply {
            //ScaleX => yatay ScaleY => dikey
            // 1.0f,2.0f: Resmi yatayda 2 kat büyütüyoruz
            //1.0f,0.50f: Resmi dikeyde yarısı kadar küçült

            duration = 3000
        }

        s.start()
    }

    fun alphaAnimasyon(){
        val a = ObjectAnimator.ofFloat(binding.imageViewResim,"alpha",0.0f,1.0f).apply {
            duration = 3000
        }

        a.start()
    }
}