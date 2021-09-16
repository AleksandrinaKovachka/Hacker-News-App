package com.example.hackernewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.hackernewsapp.adapters.PageAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val newNewsFragment = NewNewsFragment()
    private val searchNewsFragment = SearchNewsFragment()
    private val favoriteNewsFragment = FavoriteNewsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        replaceFragment(newNewsFragment)

        findViewById<BottomNavigationView>(R.id.newsNavigationView).setOnItemSelectedListener {
            when (it.itemId) {
                R.id.newsNavigation -> replaceFragment(newNewsFragment)
                R.id.searchNavigation -> replaceFragment(searchNewsFragment)
                R.id.favoriteNavigation -> replaceFragment(favoriteNewsFragment)
                else -> replaceFragment(newNewsFragment)
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }
}