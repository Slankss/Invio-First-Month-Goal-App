package com.okankkl.movieapp.util

import com.okankkl.movieapp.R
import com.okankkl.movieapp.util.Constants.NOW_PLAYING
import com.okankkl.movieapp.util.Constants.POPULAR
import com.okankkl.movieapp.util.Constants.TOP_RATED
import com.okankkl.movieapp.util.Constants.UPCOMING

enum class MovieListType(
    var routeName: String,
    val titleTextResourceId: Int
){
    Popular(
        routeName = POPULAR,
        titleTextResourceId = R.string.movie_list_type_popular
    ),
    Upcoming(
        routeName = UPCOMING,
        titleTextResourceId = R.string.movie_list_type_upcoming
    ),
    NowPlaying(
        routeName = NOW_PLAYING,
        titleTextResourceId = R.string.movie_list_type_now_playing
    ),
    TopRated(
        routeName = TOP_RATED,
        titleTextResourceId = R.string.movie_list_type_top_rated
    )
}
