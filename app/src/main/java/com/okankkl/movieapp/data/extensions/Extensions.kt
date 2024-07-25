package com.okankkl.movieapp.data.extensions

import com.okankkl.movieapp.data.remote.dto.MovieDto
import com.okankkl.movieapp.domain.model.Movie
import com.okankkl.movieapp.util.Constants
import com.okankkl.movieapp.util.Constants.NOW_PLAYING
import com.okankkl.movieapp.util.Constants.POPULAR
import com.okankkl.movieapp.util.Constants.UPCOMING
import com.okankkl.movieapp.util.MovieListType

fun Movie.getImagePath() : String  {
    // I control one of them is not empty in repository
    return when(posterPath.isNotEmpty()){
        true -> "${Constants.IMAGE_BASE_URL}$posterPath"
        false -> "${Constants.IMAGE_BASE_URL}$backdropPath"
    }
}

fun MovieDto.getMovieType(movieListTypeString: String) : MovieListType {
    return when(movieListTypeString){
        POPULAR -> MovieListType.Popular
        NOW_PLAYING -> MovieListType.NowPlaying
        UPCOMING -> MovieListType.Upcoming
        else -> MovieListType.TopRated
    }
}
