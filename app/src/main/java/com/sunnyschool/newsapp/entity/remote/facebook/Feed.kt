package com.sunnyschool.newsapp.entity.remote.facebook


import com.squareup.moshi.Json

data class Feed(
    @Json(name = "data")
    val `data`: List<Data>,
    @Json(name = "paging")
    val paging: Paging
)