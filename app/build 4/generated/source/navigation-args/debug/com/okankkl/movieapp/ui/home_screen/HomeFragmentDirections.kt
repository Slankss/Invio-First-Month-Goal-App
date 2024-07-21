package com.okankkl.movieapp.ui.home_screen

import android.os.Bundle
import androidx.navigation.NavDirections
import com.okankkl.movieapp.R
import kotlin.Int

public class HomeFragmentDirections private constructor() {
  private data class ActionHomeFragmentToMovieDetailFragment(
    public val movieId: Int = -1,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_homeFragment_to_movieDetailFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("movieId", this.movieId)
        return result
      }
  }

  public companion object {
    public fun actionHomeFragmentToMovieDetailFragment(movieId: Int = -1): NavDirections =
        ActionHomeFragmentToMovieDetailFragment(movieId)
  }
}
