package com.dicoding.picodiploma.loginwithanimation

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.loginwithanimation.databinding.ItemrowBinding

class StoryAdapter: PagingDataAdapter<ListStories, StoryAdapter.ListViewHolder>(DIFF_CALLBACK) {

    class ListViewHolder(private var binding: ItemrowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListStories) {
            binding.apply {
                username.text = item.name
                Glide.with(itemView.context)
                    .load(item.photoUrl)
                    .into(imageView)
                tvDeksripsi.text = item.description

                cardView.setOnClickListener {
                    val detailStory = Intent(itemView.context, DetailStory::class.java)
                    detailStory.putExtra(DetailStory.DETAIL_NAME, item.name)
                    detailStory.putExtra(DetailStory.DETAIL_DESKRIPSI, item.description)
                    detailStory.putExtra(DetailStory.DETAIL_PHOTO, item.photoUrl)
                    itemView.context.startActivity(detailStory)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemrowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ListStories)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListStories>() {
            override fun areItemsTheSame(oldItem: ListStories, newItem: ListStories): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ListStories, newItem: ListStories): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}