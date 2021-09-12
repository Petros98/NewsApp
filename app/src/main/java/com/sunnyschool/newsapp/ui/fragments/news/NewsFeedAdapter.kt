package com.sunnyschool.newsapp.ui.fragments.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sunnyschool.newsapp.entity.local.a1plus.Item
import com.sunnyschool.newsapp.databinding.ItemNewsBinding

class NewsFeedAdapter : ListAdapter<Item, NewsFeedAdapter.MyViewHolder>(DIFF_UTIL) {

    companion object{
        val DIFF_UTIL = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.link == newItem.link
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MyViewHolder(private val binding: ItemNewsBinding)
        : RecyclerView.ViewHolder(binding.root){
            fun bind(item: Item){
                binding.model = item
                binding.executePendingBindings()
            }
        }
}