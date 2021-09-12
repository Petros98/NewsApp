package com.sunnyschool.newsapp.data.repository

import com.sunnyschool.newsapp.data.apiservices.A1PlusApiService
import com.sunnyschool.newsapp.data.dataservice.NewsRepository
import com.sunnyschool.newsapp.entity.local.CallException
import com.sunnyschool.newsapp.entity.local.CallResult
import com.sunnyschool.newsapp.entity.local.a1plus.A1PlusRSS
import com.sunnyschool.newsapp.entity.remote.ArticleItem
import com.sunnyschool.newsapp.util.analyzeResponse
import com.sunnyschool.newsapp.util.makeApiCall

class NewsRepositoryImpl(
        private val rssService: A1PlusApiService
) : NewsRepository {

    override suspend fun getArticles(): CallResult<List<ArticleItem>?> =
        CallResult.Error(CallException(1))

    override suspend fun getA1PlusNews(): CallResult<A1PlusRSS?> =
            makeApiCall {
                analyzeResponse(rssService.getA1PlusNews())
            }

}