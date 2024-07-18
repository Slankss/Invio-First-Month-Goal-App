package com.okankkl.movieapp.ui.home_screen

import com.okankkl.movieapp.domain.model.Movie

data class HomeState(
        var contentList : List<Movie> = emptyList(),
        var isLoading: Boolean=false,
        var errorMsg: String? = null
)

