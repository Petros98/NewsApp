package com.sunnyschool.newsapp.data.repository

import android.content.Context
import com.facebook.AccessToken
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.sunnyschool.newsapp.data.dataservice.PreferenceService

class PreferenceServiceImpl(context: Context) : PreferenceService {

    private val authenticationKey = "authenticationKey"
    val sharedPreferences = context.getSharedPreferences("userData", Context.MODE_PRIVATE)

    private var token: AccessToken?
        get() = get(authenticationKey)
        set(accessToken) { put(accessToken,authenticationKey) }

    override fun setAccessToken(token: AccessToken) {
        put(token,authenticationKey)
    }

    override fun getAccessToken(): AccessToken? = token

    inline fun <reified T> get(key: String): T? {
        val value = sharedPreferences.getString(key, null)
        return value?.let {
            val jsonAdapter: JsonAdapter<T> =
                    Moshi.Builder().build().adapter(T::class.java)
            jsonAdapter.fromJson(it)
        }
    }

    inline fun <reified T> put(data: T, key: String): Boolean {
        val jsonAdapter: JsonAdapter<T> =
                Moshi.Builder().build().adapter(T::class.java)
        val jsonString = jsonAdapter.toJson(data)
        return sharedPreferences.edit().putString(key, jsonString).commit()
    }
}