package com.sunnyschool.newsapp.ui.fragments.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sunnyschool.newsapp.databinding.FragmentNewsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : Fragment() {

    private val viewModel : NewsViewModel by viewModel()
    private lateinit var binding: FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            viewModel = this@NewsFragment.viewModel
            lifecycleOwner = this@NewsFragment
        }
        observe()
    }

    private fun observe(){
        with(viewModel){
            error.observe(viewLifecycleOwner){
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
            result.observe(viewLifecycleOwner){
                Toast.makeText(context, it?.rss?.channel?.description.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

}