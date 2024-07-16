package com.okankkl.movieapp.util

sealed class Pages(val name : String){
    data object Splash : Pages("Splash")
    data object Home : Pages("Home")
    data object MovieDetail : Pages("MovieDetail")
    data object MovieSearch : Pages("MovieSearch")
    data object MovieViewAll : Pages("MovieViewAll")
    data object Profile : Pages("Profile")
}