package com.okankkl.movieapp.ui.movie_detail_screen

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class MovieDetailFragmentArgs(
  public val movieId: Int = -1,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("movieId", this.movieId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("movieId", this.movieId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): MovieDetailFragmentArgs {
      bundle.setClassLoader(MovieDetailFragmentArgs::class.java.classLoader)
      val __movieId : Int
      if (bundle.containsKey("movieId")) {
        __movieId = bundle.getInt("movieId")
      } else {
        __movieId = -1
      }
      return MovieDetailFragmentArgs(__movieId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): MovieDetailFragmentArgs {
      val __movieId : Int?
      if (savedStateHandle.contains("movieId")) {
        __movieId = savedStateHandle["movieId"]
        if (__movieId == null) {
          throw IllegalArgumentException("Argument \"movieId\" of type integer does not support null values")
        }
      } else {
        __movieId = -1
      }
      return MovieDetailFragmentArgs(__movieId)
    }
  }
}
