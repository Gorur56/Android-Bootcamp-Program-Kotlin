package com.firstapp.widgetkullanimi

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.firstapp.widgetkullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var control = false
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

        binding.buttonOku.setOnClickListener {
            val alinanVeri = binding.editTextGirdi.text.toString() //Edittexten veriyi al

            binding.textViewsonuc.text = alinanVeri // alınan veriyi textview 'e ekle.
        }

        binding.buttonResim1.setOnClickListener {
            //binding.imageView.setImageResource(R.drawable.resim1)

            //Eğer veritabanından resmi alacaksak aşağıdaki gibi düzenlememiz gerekiyor.

            binding.imageView.setImageResource(resources.getIdentifier("resim1","drawable", packageName))
        }

        binding.buttonResim2.setOnClickListener {
            //binding.imageView.setImageResource(R.drawable.resim2)

            //Eğer veritabanından resmi alacaksak aşağıdaki gibi düzenlememiz gerekiyor.

            binding.imageView.setImageResource(resources.getIdentifier("resim2","drawable", packageName))
        }


        binding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            //buttonView = switch1
            if( isChecked)
            {
                Log.e("Widgets","Switch: ON")
            }
            else
            {
                Log.e("Widgets","Switch: OFF")
            }
        }

        //Toggle Group: Yanyana butonlar oluşturur ve tekli seçim ve çoklu seçim yapabilriiz.
        binding.toggleButton.addOnButtonCheckedListener { materialButtonToggleGroup, checkedId, isChecked ->
            //çift tıklanmasını engelleme
            control = isChecked

            if(control)
            {
                //checkedId verimli çalışmadığı için toggleButton 'dan alacağız.
                val secilenButton = findViewById<Button>(binding.toggleButton.checkedButtonId)
                val secilenButtonYazi = secilenButton.text.toString()
                Log.e("Sonuc: ", secilenButtonYazi)
            }

        }

        //Expose Dropdown Menu: Kullanıcıdan girdi almamızı sağlar.
        //Aynı anda girdi, seçim ve otomatik tamamla özelliği vardır.

        val ulkeler = ArrayList<String>()
        ulkeler.add("Türkiye")
        ulkeler.add("İtalya")
        ulkeler.add("Almanya")
        ulkeler.add("İsviçre")
        ulkeler.add("Japonya")

        //Hazır tasarım adaptır kullnacağız.
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,ulkeler) //simple_list_item_1 hazır tasarım
        binding.autoCompleteText.setAdapter(arrayAdapter)


        //Progressbar: visible (Görünür), invisible (progressbar bar görünmez. Ama tıklayınca kare çizer(seçer) ),
        // gone( Hem görünmez hem tıklayınca seçmez.)

        binding.buttonGoster.setOnClickListener {
            Log.e("Sonuc", "Switch Durum: ${binding.switch1.isChecked}")

            //Çift tıklanma ve çökmemesi için çözüm
            if(control)
            {
                val secilenButton = findViewById<Button>(binding.toggleButton.checkedButtonId)
                val secilenButtonYazi = secilenButton.text.toString()
                Log.e("Sonuc: ", "Toggle Durum: $secilenButtonYazi")
            }

            val ulke = binding.autoCompleteText.text.toString()

            Log.e("Sonuc", "ülke: $ulke")
        }
    }
}