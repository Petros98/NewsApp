package com.sunnyschool.newsapp.ui.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.facebook.*
import com.sunnyschool.newsapp.databinding.FragmentProfileBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val viewModel by viewModel<ProfileViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            viewModel = this@ProfileFragment.viewModel
            lifecycleOwner =this@ProfileFragment
        }
        observe()
        setLoginButton()
    }

    private fun observe() {
        viewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
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
            fragment = this@ProfileFragment
            authType = "rerequest"
        }
    }



}