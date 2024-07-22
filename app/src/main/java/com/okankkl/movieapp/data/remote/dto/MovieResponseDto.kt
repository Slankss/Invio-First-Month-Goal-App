package com.okankkl.movieapp.data.remote.dto

data class MovieResponseDto(
    val pages :  Int,
    val results : List<MovieDto>,
    val total_pages : Int,
    var total_results : Int
)
