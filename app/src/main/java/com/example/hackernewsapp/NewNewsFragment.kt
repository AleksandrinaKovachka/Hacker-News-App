package com.example.hackernewsapp

import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.hackernewsapp.adapters.PageAdapter
import com.example.hackernewsapp.databinding.FragmentNewNewsBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class NewNewsFragment : Fragment() {
    private var _binding: FragmentNewNewsBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewPager2: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNewNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager2 = binding.newsViewPager
        viewPager2.adapter = PageAdapter(this)

        TabLayoutMediator(binding.newsTabLayout, binding.newsViewPager) {tab, position ->
            val tabName = when(position) {
                0 ->  "NEW"
                1 -> "TOP"
                2 -> "THE BEST"
                else -> "NEW"
            }
            tab.text = tabName
        }.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}