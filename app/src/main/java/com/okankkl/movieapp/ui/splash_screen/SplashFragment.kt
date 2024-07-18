package com.okankkl.movieapp.ui.splash_screen

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.blue
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.okankkl.movieapp.R
import com.okankkl.movieapp.databinding.FragmentSplashBinding
import com.okankkl.movieapp.ui.home_screen.HomeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.security.PrivateKey

@AndroidEntryPoint
class SplashFragment : Fragment()
{
    private var _binding : FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private val scope = CoroutineScope(Dispatchers.Main)
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
        
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        val rotate = AnimatorInflater.loadAnimator(view.context,R.animator.splash_animation) as AnimatorSet
        rotate.setTarget(binding.imgLogo)
        rotate.start()
        
        scope.launch {
            delay(1500)
            val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
            findNavController().navigate(
                directions = action,
                navOptions = NavOptions.Builder()
                    .setPopUpTo(R.id.splashFragment,true)
                    .build()
            )
            
        }
    }
    
    override fun onDestroy()
    {
        super.onDestroy()
        _binding = null
    }
}