package com.sunnyschool.newsapp.data.dataservice

import com.sunnyschool.newsapp.entity.local.CallResult
import com.sunnyschool.newsapp.entity.local.a1plus.A1PlusRSS
import com.sunnyschool.newsapp.entity.remote.ArticleItem

interface NewsRepository {
    suspend fun getArticles() : CallResult<List<ArticleItem>?>
    suspend fun getA1PlusNews() : CallResult<A1PlusRSS?>
}