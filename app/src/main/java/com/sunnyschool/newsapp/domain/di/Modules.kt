package com.sunnyschool.newsapp.domain.di

import com.sunnyschool.newsapp.domain.interactors.NewsInteractor
import com.sunnyschool.newsapp.domain.usecases.NewsUseCase
import org.koin.dsl.module

val interactorsModule = module {
    single<NewsInteractor> { NewsUseCase(get()) }
}