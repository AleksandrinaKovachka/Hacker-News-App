package com.example.hackernewsapp.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hackernewsapp.NewNewsFragment
import com.example.hackernewsapp.TheBestNewsFragment
import com.example.hackernewsapp.TopNewsFragment

class PageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> NewNewsFragment.newInstance()
            1 -> TopNewsFragment.newInstance()
            2 -> TheBestNewsFragment.newInstance()
            else -> NewNewsFragment.newInstance()
        }
    }
}