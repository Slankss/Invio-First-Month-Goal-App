package com.okankkl.movieapp.ui

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.createGraph
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.okankkl.movieapp.R
import com.okankkl.movieapp.databinding.ActivityMainBinding
import com.okankkl.movieapp.util.Pages
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity()
{
    val viewModel : MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(0, systemBars.top, 0,0)
            insets
        }
        
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavitionView =binding.bottomNavigationView
        
        bottomNavitionView.setupWithNavController(navController)
        
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.splashFragment -> bottomNavitionView.visibility = View.GONE
                else -> bottomNavitionView.visibility = View.VISIBLE
            }
        }
        viewModel.clearUpdateTime()
    }
}