package com.sunnyschool.newsapp.entity.remote.facebook


import com.squareup.moshi.Json

data class Data(
    @Json(name = "created_time")
    val createdTime: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "message")
    val message: String
)