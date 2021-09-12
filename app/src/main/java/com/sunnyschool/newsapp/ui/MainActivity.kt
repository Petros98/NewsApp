package com.sunnyschool.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sunnyschool.newsapp.R

class MainActivity : AppCompatActivity() {

private val navController: NavController
    get() = findViewById<FragmentContainerView>(R.id.mainContainer).findNavController()

    private val bottomMenu : BottomNavigationView by lazy { findViewById(R.id.bottomNavigationView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
        bottomMenu.setupWithNavController(navController)
    }

}