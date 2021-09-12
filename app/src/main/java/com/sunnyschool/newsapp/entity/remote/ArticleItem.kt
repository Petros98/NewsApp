package com.sunnyschool.newsapp.entity.remote

data class ArticleItem(
        val events: List<Event>,
        val featured: Boolean,
        val id: String,
        val imageUrl: String,
        val launches: List<Launche>,
        val newsSite: String,
        val publishedAt: String,
        val summary: String,
        val title: String,
        val url: String
)