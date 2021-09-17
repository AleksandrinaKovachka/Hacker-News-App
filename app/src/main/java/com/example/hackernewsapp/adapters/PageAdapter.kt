package com.example.hackernewsapp.adapters

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hackernewsapp.ArticleFragment
import com.example.hackernewsapp.NewNewsFragment

const val PAGER_POSITION = "Position"

class PageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = ArticleFragment()
        fragment.arguments = Bundle().apply {
            putInt(PAGER_POSITION, position)
        }

        return fragment
    }
}