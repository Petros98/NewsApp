package com.sunnyschool.newsapp.entity.remote.facebook


import com.squareup.moshi.Json

data class Cursors(
    @Json(name = "after")
    val after: String,
    @Json(name = "before")
    val before: String
)