package com.sunnyschool.newsapp.ui.fragments.news

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sunnyschool.newsapp.entity.local.a1plus.Item
import com.sunnyschool.newsapp.entity.remote.ArticleItem
import com.sunnyschool.newsapp.domain.interactors.NewsInteractor
import com.sunnyschool.newsapp.entity.local.CallResult
import com.sunnyschool.newsapp.entity.local.a1plus.A1PlusRSS
import kotlinx.coroutines.launch

class NewsViewModel(
        private val interactor: NewsInteractor
) : ViewModel() {

    private val _names by lazy { MutableLiveData<ArticleItem>() }
    val names: LiveData<ArticleItem> get() = _names

    private val _newsItems by lazy { MutableLiveData<List<Item>>() }
    val newsItems: LiveData<List<Item>> get() = _newsItems

    private val _result by lazy { MutableLiveData<A1PlusRSS?>() }
    val result: LiveData<A1PlusRSS?> get() = _result

    private val _error by lazy { MutableLiveData<String>() }
    val error: LiveData<String> get() = _error

    init {

    }

    fun getData(){
        Log.i("getData", "clicked")
        viewModelScope.launch {
            when(val data = interactor.getA1PlusNews()){
                is CallResult.Success ->{
                    _result.postValue(data.data)
                }
                is CallResult.Error ->{
                    _error.postValue(data.errors.errorMessage)
                }
            }
        }
    }

}