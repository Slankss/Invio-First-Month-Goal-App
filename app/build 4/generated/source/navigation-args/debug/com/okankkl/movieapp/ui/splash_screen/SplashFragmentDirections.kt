package com.okankkl.movieapp.ui.splash_screen

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.okankkl.movieapp.R

public class SplashFragmentDirections private constructor() {
  public companion object {
    public fun actionSplashFragmentToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_splashFragment_to_homeFragment)
  }
}
