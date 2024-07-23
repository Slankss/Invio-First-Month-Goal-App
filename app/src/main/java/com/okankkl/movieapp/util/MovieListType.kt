package com.okankkl.movieapp.util

import com.okankkl.movieapp.R

enum class MovieListType(
    var routeName: String,
    val titleTextResourceId: Int
){
    Popular(
        routeName = "popular",
        titleTextResourceId = R.string.movie_list_type_popular
    ),
    Upcoming(
        routeName = "upcoming",
        titleTextResourceId = R.string.movie_list_type_upcoming
    ),
    NowPlaying(
        routeName = "now_playing",
        titleTextResourceId = R.string.movie_list_type_now_playing
    ),
    TopRated(
        routeName = "top_rated",
        titleTextResourceId = R.string.movie_list_type_top_rated
    )
}
