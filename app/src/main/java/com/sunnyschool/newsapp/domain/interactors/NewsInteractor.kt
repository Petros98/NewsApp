package com.sunnyschool.newsapp.domain.interactors

import com.sunnyschool.newsapp.entity.local.CallResult
import com.sunnyschool.newsapp.entity.local.a1plus.A1PlusRSS
import com.sunnyschool.newsapp.entity.remote.ArticleItem

interface NewsInteractor {
    suspend fun getArticles(): List<ArticleItem>?
    suspend fun getA1PlusNews() : CallResult<A1PlusRSS?>
}