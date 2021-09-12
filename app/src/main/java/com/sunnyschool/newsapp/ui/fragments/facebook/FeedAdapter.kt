package com.sunnyschool.newsapp.ui.fragments.facebook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sunnyschool.newsapp.entity.remote.facebook.Data
import com.sunnyschool.newsapp.databinding.ItemFacebookFeedBinding

class FeedAdapter : ListAdapter<Data, FeedAdapter.MyViewHolder>(DIFF_UTIL) {

    companion object{
        val DIFF_UTIL = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemFacebookFeedBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MyViewHolder(private val binding: ItemFacebookFeedBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Data){
            binding.model = item
            binding.executePendingBindings()
        }
    }
}