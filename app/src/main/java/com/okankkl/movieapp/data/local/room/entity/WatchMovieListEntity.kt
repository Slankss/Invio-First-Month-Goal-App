package com.okankkl.movieapp.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "watch_movie_list")
data class WatchMovieListEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val movie_id: String,
    val title: String,
    val posterPath: String,
    val backdropPath: String
)
