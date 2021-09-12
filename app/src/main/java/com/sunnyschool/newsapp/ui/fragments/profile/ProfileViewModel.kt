package com.sunnyschool.newsapp.ui.fragments.profile

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.facebook.*
import org.json.JSONException
import org.json.JSONObject

class ProfileViewModel : ViewModel() {

    private val _actionOpenFacebook by lazy { MutableLiveData<Boolean>() }
    val actionOpenFacebook: LiveData<Boolean> get() = _actionOpenFacebook

    private val _profile by lazy { MutableLiveData<Profile>() }
    val profile: LiveData<Profile> get() = _profile

    private val _error by lazy { MutableLiveData<String>() }
    val error: LiveData<String> get() = _error

    private val _id by lazy { MutableLiveData<String>() }
    val id: LiveData<String> get() = _id

    private val _image by lazy { MutableLiveData<String>() }
    val image: LiveData<String> get() = _image

    private val _name by lazy { MutableLiveData<String>() }
    val name: LiveData<String> get() = _name

    fun openFacebook(){
        _actionOpenFacebook.value = true
    }

    init {
        Profile.getCurrentProfile().let {
            _profile.value = it
//            _name.value =  it.firstName
//            _id.value = it.id
//            _image.value = "http://graph.facebook.com/$id/picture?type=large"
        }
    }

    var tokenTracker = object : AccessTokenTracker(){
        override fun onCurrentAccessTokenChanged(
            oldAccessToken: AccessToken?,
            currentAccessToken: AccessToken?
        ) {
            currentAccessToken?.let {
                loadUser(it)
                _profile.value = Profile.getCurrentProfile()
            }
        }
    }

    private fun loadUser(accessToken: AccessToken){
        val request = GraphRequest.newMeRequest(accessToken) { jsonObject: JSONObject, graphResponse: GraphResponse ->
            try {
                _name.value =  jsonObject.getString("first_name")
                _id.value = jsonObject.getString("id")
                _image.value = "http://graph.facebook.com/$id/picture?type=large"
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
}