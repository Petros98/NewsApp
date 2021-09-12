package com.sunnyschool.newsapp.ui.di

import com.sunnyschool.newsapp.ui.fragments.facebook.FacebookViewModel
import com.sunnyschool.newsapp.ui.fragments.news.NewsViewModel
import com.sunnyschool.newsapp.ui.fragments.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel { NewsViewModel(get()) }
    viewModel { ProfileViewModel() }
    viewModel { FacebookViewModel() }
}