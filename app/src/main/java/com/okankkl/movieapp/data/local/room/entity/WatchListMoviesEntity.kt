package com.okankkl.movieapp.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "watch_list_movies")
data class WatchListMoviesEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val list_id : Int,
    val movie_id: String,
    val posterPath: String,
    val backdropPath: String
)
