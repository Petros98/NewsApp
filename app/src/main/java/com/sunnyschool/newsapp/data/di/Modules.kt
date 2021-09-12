package com.sunnyschool.newsapp.data.di

import com.squareup.moshi.Moshi
import com.sunnyschool.newsapp.data.apiservices.A1PlusApiService
import com.sunnyschool.newsapp.data.dataservice.NewsRepository
import com.sunnyschool.newsapp.data.apiservices.RssRetrofitService
import com.sunnyschool.newsapp.data.repository.NewsRepositoryImpl
import me.toptas.rssconverter.RssConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { Moshi.Builder().build() }

//    single<Retrofit> {
//        Retrofit.Builder()
//            .baseUrl("https://api.rss2json.com")
//                .addConverterFactory(MoshiConverterFactory.create())
//                .apply {
//                    client(
//                            OkHttpClient.Builder()
//                                    .addInterceptor(HttpLoggingInterceptor().apply {
//                                        level = HttpLoggingInterceptor.Level.BODY
//                                    })
//                                    .build()
//                    )
//                }
//                .build()
//    }
//    single<RetrofitService> { get<Retrofit>().create(RetrofitService::class.java) }

}

val rssModule = module {

    single<Retrofit> { Retrofit.Builder()
            .baseUrl("https://api.rss2json.com")
            .addConverterFactory(RssConverterFactory.create())
            .apply {
                client(
                  OkHttpClient.Builder()
                      .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
        }
            .build()
    }

    single<RssRetrofitService> { get<Retrofit>().create(RssRetrofitService::class.java) }
    single<A1PlusApiService> { get<Retrofit>().create(A1PlusApiService::class.java)}
}

val repositoryModule = module {
    single<NewsRepository> { NewsRepositoryImpl(get()) }
}
