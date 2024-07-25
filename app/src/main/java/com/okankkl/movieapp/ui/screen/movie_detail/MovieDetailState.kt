package com.okankkl.movieapp.ui.screen.movie_detail

import com.okankkl.movieapp.data.model.Movie

data class MovieDetailState(
        var movie : Movie? = null,
        var isLoading : Boolean = false,
        var errorMessage : String = "",
        var similarMovies : List<Movie>? = null
)