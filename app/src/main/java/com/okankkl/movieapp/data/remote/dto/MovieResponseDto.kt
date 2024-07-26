package com.okankkl.movieapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieResponseDto(
        val pages :  Int?,
        val results : List<MovieDto>,
        @SerializedName("total_pages")
        val totalPages : Int?,
        @SerializedName("total_results")
        var totalResults : Int?
)
