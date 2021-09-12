package com.sunnyschool.newsapp.data.dataservice

import com.facebook.AccessToken

interface PreferenceService {

    fun setAccessToken(token: AccessToken)
    fun getAccessToken() : AccessToken?

}