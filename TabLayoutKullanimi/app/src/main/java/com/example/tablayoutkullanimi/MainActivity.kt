package com.example.tablayoutkullanimi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private val fragmentList = ArrayList<Fragment>()
    private val fragmentBaslikList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fragmentList.add(BirinciFragment())
        fragmentList.add(IkinciFragment())
        fragmentList.add(UcuncuFragment())

        val adapter = MyViewPagerAdapter(this)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        viewPager.adapter = adapter

        fragmentBaslikList.add("Bir")
        fragmentBaslikList.add("İki")
        fragmentBaslikList.add("Üç")

        val tabLayout: TabLayout = findViewById(R.id.tablayout)
        TabLayoutMediator(tabLayout, viewPager){tab, position ->
            tab.setText(fragmentBaslikList[position])
        }.attach()

        tabLayout.getTabAt(0)?.setIcon(R.drawable.dolar_icon)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ikinci_icon)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.ucuncu_icon)
    }

    inner class MyViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }

    }
}