package com.example.hackernewsapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackernewsapp.adapters.NewsAdapter
import com.example.hackernewsapp.adapters.PAGER_POSITION
import com.example.hackernewsapp.data.News
import com.example.hackernewsapp.databinding.FragmentArticleBinding
import com.example.hackernewsapp.databinding.FragmentNewNewsBinding
import kotlinx.coroutines.launch


class ArticleFragment() : Fragment() {
    private var _binding: FragmentArticleBinding? = null
    private val binding get() = _binding!!

    private var position : Int = 0
    private val newsAdapter = NewsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.apply {
            //getInt(PAGER_POSITION)
            position = getInt(PAGER_POSITION)
        }
        Log.i("TAG", "Position is: $position")

        val news : List<News> = listOf<News>(News("Name", "Author", "1 hour ago", 1, true, 12))
        val newsTop : List<News> = listOf<News>(News("Name1", "Author1", "2 hour ago", 2, false, 12))
        val newsTheBest : List<News> = listOf<News>(News("Name2", "Author2", "3 hour ago", 3, false, 12))


        binding.newsRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.newsRecyclerView.adapter = newsAdapter

        lifecycle.coroutineScope.launch {
            when (position) {
                0 -> newsAdapter.submitList(news)
                1 -> newsAdapter.submitList(newsTop)
                2 -> newsAdapter.submitList(newsTheBest)
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}