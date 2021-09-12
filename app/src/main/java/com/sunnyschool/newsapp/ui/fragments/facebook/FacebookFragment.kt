package com.sunnyschool.newsapp.ui.fragments.facebook

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.facebook.*
import com.facebook.appevents.AppEventsLogger
import com.sunnyschool.newsapp.core.MyApp
import com.sunnyschool.newsapp.databinding.FragmentFacebookBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class FacebookFragment : Fragment() {

    private lateinit var binding: FragmentFacebookBinding
    private val viewModel by viewModel<FacebookViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        AppEventsLogger.activateApp(MyApp.getInstance())
        binding = FragmentFacebookBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            viewModel = this@FacebookFragment.viewModel
            lifecycleOwner = this@FacebookFragment
        }
        setLoginButton()
//        LoginManager.getInstance().registerCallback(callbackManager, object :
//                FacebookCallback<LoginResult?> {
//            override fun onSuccess(loginResult: LoginResult?) {
//                Toast.makeText(context, loginResult?.accessToken?.source?.name, Toast.LENGTH_SHORT).show()
//                activity?.setResult(Activity.RESULT_OK)
//            }
//
//            override fun onCancel() {
//                Toast.makeText(context, "canceled", Toast.LENGTH_SHORT).show()
//                activity?.setResult(Activity.RESULT_CANCELED)
//            }
//
//            override fun onError(exception: FacebookException) {
//                Toast.makeText(context, exception.message, Toast.LENGTH_SHORT).show()
//            }
//        })
    }

    private fun setLoginButton(){
        binding.loginButton.apply {
            setPermissions(
                    listOf(
                            "email",
                            "public_profile",
                            "user_posts",
                            "pages_read_engagement",
                            "pages_read_user_content"
                    ))
            fragment = this@FacebookFragment
            authType = "rerequest"
        }
        viewModel.login()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        viewModel.callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

}