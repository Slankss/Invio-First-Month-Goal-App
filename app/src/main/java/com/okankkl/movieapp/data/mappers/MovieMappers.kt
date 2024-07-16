package com.okankkl.movieapp.data.mappers

import com.okankkl.movieapp.data.remote.dto.MovieDto
import com.okankkl.movieapp.domain.model.Movie
import com.okankkl.movieapp.util.Constants

fun MovieDto.toMovie() : Movie = Movie(
    id = id,
    title = title,
    posterPath = imagePath(poster_path),
    backdropPath = imagePath(backdrop_path),
)

private fun imagePath(path : String) : String = "${Constants.IMAGE_BASE_URL}$path"