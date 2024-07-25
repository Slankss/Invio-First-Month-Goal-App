package com.okankkl.movieapp.util

object Constants
{
    const val API_BASE_URL = "https://api.themoviedb.org/3/"
    const val API_KEY = "ef04889b073508dc226ff8ebb049bebd"
    const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
    const val YOUTUBE_VIDEO_URL = "https://www.youtube.com/watch?v="
    
    const val MOVIE_ID_ARG = "movieId"
    const val MOVIE_TYPE_ARG = "movieTypeRouteName"
    const val MOVIE_TYPE_STRING_ID_ARG = "movieTypeNameStringId"
    
    const val POPULAR = "popular"
    const val UPCOMING = "upcoming"
    const val TOP_RATED = "top_rated"
    const val NOW_PLAYING = "now_playing"
    
    const val GET_MOVIES_ROUTE = "movie/{listType}"
    const val GET_MOVIE_DETAIL_ROUTE = "movie/{movieId}"
    const val GET_SIMILAR_MOVIES_ROUTE = "movie/{movieId}/similar"
    const val SEARCH_MOVIES_ROUTE = "search/movie"
}