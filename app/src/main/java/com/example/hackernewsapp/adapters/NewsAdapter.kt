package com.example.hackernewsapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hackernewsapp.R
import com.example.hackernewsapp.data.News
import com.example.hackernewsapp.databinding.NewsLayoutBinding

class NewsAdapter : ListAdapter<News, NewsAdapter.NewsAdapterViewHolder>(NewsComparator()) {
    class NewsAdapterViewHolder(private val binding: NewsLayoutBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(news: News) {
                    binding.nameOfNewsTextView.text = news.nameOfNews
                    binding.scoreTextView.text = news.score.toString()
                    binding.authorTextView.text = news.author
                    binding.timeOfPublicationTextView.text = news.publicationTime
                    binding.numberOfCommentsTextView.text = news.numberOfComments.toString()
                    if (news.like) {
                        binding.likeImageButton.setImageResource(R.drawable.ic_favorite_full)
                    } else {
                        binding.likeImageButton.setImageResource(R.drawable.ic_favorite_board)
                    }
                }
            }

    class NewsComparator : DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.nameOfNews == newItem.nameOfNews
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapterViewHolder {
        return NewsAdapterViewHolder(
            NewsLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsAdapterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}