package com.okankkl.movieapp.data.mappers

import com.okankkl.movieapp.data.extensions.getMovieType
import com.okankkl.movieapp.data.local.room.entity.MovieEntity
import com.okankkl.movieapp.data.model.Movie
import com.okankkl.movieapp.data.remote.dto.MovieDetailDto
import com.okankkl.movieapp.data.remote.dto.MovieDto
import com.okankkl.movieapp.util.MovieListType

fun MovieDto.toMovie(movieListType: MovieListType? = null) : Movie = Movie(
    id = id,
    title = title ?: "",
    posterPath = posterPath ?: "",
    backdropPath = backdropPath ?: "",
    movieListType = movieListType
)

fun Movie.toMovieEntity() : MovieEntity = MovieEntity(
    movieId = id ?: 0,
    title = title,
    posterPath = posterPath,
    backdropPath = backdropPath,
    movieListType = movieListType?.routeName  ?: ""
)

fun MovieEntity.toMovie() : Movie = Movie(
    id = movieId,
    title = title ?: "",
    posterPath = posterPath ?: "",
    backdropPath = backdropPath ?: "",
    movieListType = getMovieType(movieListType)
)

fun MovieDetailDto.toMovie() : Movie = Movie(
    id = id,
    title = title ?: "",
    posterPath = posterPath ?: "",
    backdropPath = backdropPath ?: "",
    overview = overview ?: "",
    releaseDate = releaseDate ?: "",
    voteAverage = voteAverage ?: 0.0,
    genres = genres,
    runtime = runtime ?: 0,
    videos = videos
)
