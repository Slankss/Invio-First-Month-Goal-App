package com.okankkl.movieapp.domain.model

import com.okankkl.movieapp.util.MovieListType

data class Category(
    var listType: MovieListType,
    var movieList: List<Movie>
)
