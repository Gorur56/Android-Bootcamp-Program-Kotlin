package com.example.mvvmkullanimi

import android.os.Bundle
import android.view.inputmethod.InputBinding
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.mvvmkullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel:MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //binding = ActivityMainBinding.inflate(layoutInflater)

        //DataBinding => Görsel tasarım kodlarını daha çok layout dosyasına aktarır
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.mainActivityNesnesi = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Diğer kısımlar ViewBinding ile aynıdır. Sonucu Layour 'da aktarıyoruz.
        //binding.textVieSonuc.text = "0"
        //binding.hesaplamaSonucu = "0" //ViewModel 'de değeri oku

        //Bu kodu 3 defa çalıştırmayı engellemek için LIVEDATA kullanıyoruz.
        //Değeri gözlemliyoruz.
        viewModel.sonuc.observe(this){
            binding.hesaplamaSonucu = it
        }
        //Aşağıdaki satıra artık gerek yok
        //binding.hesaplamaSonucu = viewModel.sonuc

        /*binding.buttonTopla.setOnClickListener {
            val alinanSayi1 = binding.editTextTextSayi1.text.toString()
            val alinanSayi2 = binding.editTextTextSAyi2.text.toString()

            val sayi1 = alinanSayi1.toInt()
            val sayi2 = alinanSayi2.toInt()

            val toplam = sayi1 + sayi2

            binding.textVieSonuc.text = toplam.toString()
        }

        binding.buttonCarpma.setOnClickListener {
            val alinanSayi1 = binding.editTextTextSayi1.text.toString()
            val alinanSayi2 = binding.editTextTextSAyi2.text.toString()

            val sayi1 = alinanSayi1.toInt()
            val sayi2 = alinanSayi2.toInt()

            val carpma = sayi1 * sayi2
            binding.textVieSonuc.text = carpma.toString()
        }*/
    }

    fun buttonToplamaTikla(alinanSayi1:String, alinanSayi2: String){
        //val alinanSayi1 = binding.editTextTextSayi1.text.toString() //Gerek yok tasarıma yaptıracağız
        //val alinanSayi2 = binding.editTextTextSAyi2.text.toString()

        /*val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()
        val toplam = sayi1 + sayi2*/

        //binding.textVieSonuc.text = toplam.toString() //Layout sayfasına ekledik.
        viewModel.toplamaYap(alinanSayi1,alinanSayi2)
        //binding.hesaplamaSonucu = toplam.toString()
        //binding.hesaplamaSonucu = viewModel.sonuc
    }

    fun buttonCarpmaTikla(alinanSayi1:String, alinanSayi2: String){
        //val alinanSayi1 = binding.editTextTextSayi1.text.toString()
        //val alinanSayi2 = binding.editTextTextSAyi2.text.toString()

        /*val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()

        val carpma = sayi1 * sayi2*/
        //binding.textVieSonuc.text = carpma.toString()

        viewModel.carpmaYap(alinanSayi1,alinanSayi2)
        //binding.hesaplamaSonucu = carpma.toString()
        //binding.hesaplamaSonucu = viewModel.sonuc
    }
}