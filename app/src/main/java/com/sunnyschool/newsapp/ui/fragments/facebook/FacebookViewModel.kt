package com.sunnyschool.newsapp.ui.fragments.facebook

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.sunnyschool.newsapp.entity.remote.facebook.Data
import org.json.JSONException
import org.json.JSONObject

class FacebookViewModel : ViewModel() {

    private val _newsData by lazy { MutableLiveData<List<Data>>() }
    val newsData:LiveData<List<Data>> get() = _newsData

    private val _profile by lazy { MutableLiveData<Profile>() }
    val profile: LiveData<Profile> get() = _profile

    private val _id by lazy { MutableLiveData<String>() }
    val id: LiveData<String> get() = _id

    private val _error by lazy { MutableLiveData<String>() }
    val error: LiveData<String> get() = _error

    var callbackManager: CallbackManager = CallbackManager.Factory.create()

    val imageUrl by lazy {
        MediatorLiveData<String>().apply {
            addSource(id){
                it?.let {
                    value = "https://graph.facebook.com/${it}/picture?type=small"
                }
            }
        }
    }

    init {
        _profile.value = Profile.getCurrentProfile()
        AccessToken.getCurrentAccessToken()?.let {
            loadUser(it)
        }
    }

    private fun loadUser(accessToken: AccessToken){
        val request = GraphRequest.newMeRequest(accessToken) { jsonObject: JSONObject, graphResponse: GraphResponse ->
            try {
//                _name.value =  jsonObject.getString("first_name")
                _id.value = jsonObject.getString("id")
//                _image.value = "http://graph.facebook.com/$id/picture?type=large"
            }
            catch (e: JSONException){
                _error.value = e.message
            }
        }

        request.parameters = Bundle().apply {
            putString("fields", "first_name,last_name,email,id")
        }
        request.executeAsync()

    }

    fun login(){
        LoginManager.getInstance().registerCallback(callbackManager, object :
                FacebookCallback<LoginResult?> {
            override fun onSuccess(loginResult: LoginResult?) {
                _error.value = loginResult?.accessToken.toString()
            }

            override fun onCancel() {
                _error.value = "canceled"
            }

            override fun onError(exception: FacebookException) {
                _error.value  = exception.message
            }
        })
    }

}