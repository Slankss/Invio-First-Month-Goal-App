package com.okankkl.movieapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDetailDto(
        @SerializedName("backdrop_path")
        val backdropPath: String?,
        val genres: List<Genre>?,
        val id: Int?,
        val overview: String?,
        val popularity: Double?,
        @SerializedName("poster_path")
        val posterPath: String?,
        @SerializedName("release_path")
        val releaseDate: String?,
        val revenue: Int?,
        val runtime: Int?,
        val title: String?,
        val video: Boolean?,
        val videos: Videos?,
        @SerializedName("vote_average")
        val voteAverage: Double?,
        @SerializedName("vote_count")
        val voteCount: Int?
)