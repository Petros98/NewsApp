package com.sunnyschool.newsapp.data.apiservices

import com.sunnyschool.newsapp.entity.local.a1plus.A1PlusRSS
import com.sunnyschool.newsapp.entity.remote.ArticleItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface A1PlusApiService {

    @Headers("Content-Type: application/json")
    @GET("/api/v2/articles")
    suspend fun getArticles() : Response<List<ArticleItem>>

    @Headers("Content-Type: application/json")
    @GET("/v1/api.json?rss_url=https%3A%2F%2Fa1plus.am%2Fen%2Frss")
    suspend fun getA1PlusNews() : Response<A1PlusRSS>
}