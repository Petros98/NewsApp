package com.sunnyschool.newsapp.entity.remote.facebook


import com.squareup.moshi.Json
import com.sunnyschool.newsapp.entity.remote.facebook.Cursors

data class Paging(
    @Json(name = "cursors")
    val cursors: Cursors,
    @Json(name = "next")
    val next: String
)