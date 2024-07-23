package com.okankkl.movieapp.ui.screen.splash
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.animation.doOnEnd
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.okankkl.movieapp.R
import com.okankkl.movieapp.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment()
{
    private var _binding : FragmentSplashBinding? = null
    private val binding get() = _binding!!
    
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
        val scale = AnimatorInflater.loadAnimator(view.context,R.animator.splash_animation) as AnimatorSet
        scale.setTarget(binding.imgLogo)
        scale.start()
        scale.doOnEnd {
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