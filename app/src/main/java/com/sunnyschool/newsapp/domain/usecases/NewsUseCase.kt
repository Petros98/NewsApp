package com.sunnyschool.newsapp.domain.usecases

import com.sunnyschool.newsapp.data.dataservice.NewsRepository
import com.sunnyschool.newsapp.entity.local.CallResult
import com.sunnyschool.newsapp.entity.local.a1plus.A1PlusRSS
import com.sunnyschool.newsapp.entity.remote.ArticleItem
import com.sunnyschool.newsapp.domain.interactors.NewsInteractor
import com.sunnyschool.newsapp.entity.local.CallException

class NewsUseCase(
    private val repository: NewsRepository
) : NewsInteractor {

    override suspend fun getArticles(): List<ArticleItem>? {
        return when(val data = repository.getArticles()){
            is CallResult.Success ->{
                data.data
            }
            else ->{
                null
            }
        }
    }

    override suspend fun getA1PlusNews(): CallResult<A1PlusRSS?> {
        return when(val data = repository.getA1PlusNews()){
            is CallResult.Success ->{
                CallResult.Success(data.data)
            }
            is CallResult.Error ->{
                CallResult.Error(
                    CallException(
                        data.errors.errorCode,
                        data.errors.errorMessage
                )
                )
            }
        }
    }
}