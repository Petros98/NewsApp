package com.sunnyschool.newsapp.core

import android.app.Application
import com.sunnyschool.newsapp.data.di.apiModule
import com.sunnyschool.newsapp.data.di.repositoryModule
import com.sunnyschool.newsapp.data.di.rssModule
import com.sunnyschool.newsapp.domain.di.interactorsModule
import com.sunnyschool.newsapp.ui.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(modules)
        }
    }

    private val modules = listOf(
            apiModule,
            rssModule,
            viewModule,
            repositoryModule,
            interactorsModule,
    )

    companion object{
        private lateinit var instance: MyApp
        fun getInstance(): MyApp {
            return if (this::instance.isInitialized) instance
                else MyApp()
        }
    }
}