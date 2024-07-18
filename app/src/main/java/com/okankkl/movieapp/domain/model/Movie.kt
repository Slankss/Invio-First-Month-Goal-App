package com.okankkl.movieapp.domain.model

import com.okankkl.movieapp.util.MovieListType

class Movie(
    val backdropPath: String,
    val id: Int,
    val posterPath: String,
    val title: String,
    val movieListType: MovieListType
)
