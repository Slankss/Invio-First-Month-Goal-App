package com.okankkl.movieapp.data.mappers

import com.okankkl.movieapp.data.local.room.entity.MovieEntity
import com.okankkl.movieapp.data.remote.dto.MovieDto
import com.okankkl.movieapp.domain.model.Movie
import com.okankkl.movieapp.util.Constants
import com.okankkl.movieapp.util.MovieListType

fun MovieDto.toMovie(movieListType: MovieListType) : Movie = Movie(
    id = id,
    title = title,
    posterPath = imagePath(poster_path),
    backdropPath = imagePath(backdrop_path),
    movieListType = movieListType
)

fun Movie.toMovieEntity() : MovieEntity = MovieEntity(
    movieId = id,
    title = title,
    posterPath = posterPath,
    backdropPath = backdropPath,
    movieListType = movieListType.routeName
)

fun MovieEntity.toMovie() : Movie = Movie(
    id = movieId,
    title = title,
    posterPath = posterPath,
    backdropPath = backdropPath,
    movieListType = getMovieType(movieListType)
)

private fun imagePath(path : String) : String = "${Constants.IMAGE_BASE_URL}$path"

private fun getMovieType(movieListTypeString: String) : MovieListType {
    return when(movieListTypeString){
        "popular" -> MovieListType.Popular
        "now_playing" -> MovieListType.NowPlaying
        "upcoming" -> MovieListType.Upcoming
        else -> MovieListType.TopRated
    }
}