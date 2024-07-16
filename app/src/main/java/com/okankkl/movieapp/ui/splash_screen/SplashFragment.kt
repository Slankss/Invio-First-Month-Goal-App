package com.okankkl.movieapp.ui.splash_screen

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.okankkl.movieapp.R
import com.okankkl.movieapp.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment()
{
    private var _binding : FragmentSplashBinding? = null
    private val binding get() = _binding!!
    
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }
    
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View
    {
        _binding = FragmentSplashBinding.inflate(inflater,container,false)
        val view = binding.root
        
        val rotate = AnimatorInflater.loadAnimator(view.context,R.animator.splash_animation) as AnimatorSet
        rotate.setTarget(binding.imgLogo)
        rotate.start()
        
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        val viewModel : SplashFragmentViewModel by viewModels()
        viewModel.loadMovies("")
        
    }
    
    override fun onDestroy()
    {
        super.onDestroy()
        _binding = null
    }
}