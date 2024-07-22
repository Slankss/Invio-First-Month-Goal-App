package com.okankkl.movieapp.util

import com.okankkl.movieapp.R

sealed class MovieListType(val routeName : String,val titleTextId: Int){
    object Popular : MovieListType(routeName = "popular", titleTextId = R.string.movie_list_type_popular)
    object Upcoming : MovieListType(routeName = "upcoming", titleTextId = R.string.movie_list_type_upcoming)
    object NowPlaying : MovieListType(routeName = "now_playing", titleTextId = R.string.movie_list_type_now_playing)
    object TopRated : MovieListType(routeName = "top_rated", titleTextId = R.string.movie_list_type_top_rated)
}

