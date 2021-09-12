package com.sunnyschool.newsapp.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.facebook.login.widget.ProfilePictureView
import com.sunnyschool.newsapp.entity.local.a1plus.Item
import com.sunnyschool.newsapp.entity.remote.facebook.Data
import com.sunnyschool.newsapp.ui.fragments.facebook.FeedAdapter
import com.sunnyschool.newsapp.ui.fragments.news.NewsFeedAdapter

@BindingAdapter("news_rv_list")
fun RecyclerView.bindList(list: List<Item>?){
    if (this.adapter == null)
        adapter = NewsFeedAdapter().apply { submitList(list) }
    else
        (this.adapter is NewsFeedAdapter)
            (adapter as NewsFeedAdapter).submitList(list)
}

@BindingAdapter("image_url")
fun ImageView.bindImage(url: String?){
    Glide.with(this)
            .load(url)
            .into(this)
}

@BindingAdapter("profile_id")
fun ProfilePictureView.bindImage(id: String?){
    this.profileId = id
}

@BindingAdapter("feed_rv_list")
fun RecyclerView.addList(list: List<Data>?){
    if (this.adapter == null)
        adapter = FeedAdapter().apply { submitList(list) }
    else
        (this.adapter is NewsFeedAdapter)
    (adapter as FeedAdapter).submitList(list)
}