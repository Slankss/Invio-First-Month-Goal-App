package com.okankkl.movieapp.data.remote.dto

data class MovieDetailDto(
        val backdrop_path: String?,
        val genres: List<Genre>,
        val id: Int,
        val overview: String,
        val popularity: Double,
        val poster_path: String?,
        val release_date: String,
        val revenue: Int,
        val runtime: Int,
        val title: String,
        val video: Boolean,
        val videos: Videos?,
        val vote_average: Double,
        val vote_count: Int
)