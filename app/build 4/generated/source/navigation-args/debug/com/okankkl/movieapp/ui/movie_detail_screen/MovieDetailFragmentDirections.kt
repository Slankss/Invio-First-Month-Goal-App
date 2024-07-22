package com.okankkl.movieapp.ui.movie_detail_screen

import android.os.Bundle
import androidx.navigation.NavDirections
import com.okankkl.movieapp.R
import kotlin.Int

public class MovieDetailFragmentDirections private constructor() {
  private data class ActionMovieDetailFragmentSelf(
    public val movieId: Int = -1,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_movieDetailFragment_self

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("movieId", this.movieId)
        return result
      }
  }

  public companion object {
    public fun actionMovieDetailFragmentSelf(movieId: Int = -1): NavDirections =
        ActionMovieDetailFragmentSelf(movieId)
  }
}
