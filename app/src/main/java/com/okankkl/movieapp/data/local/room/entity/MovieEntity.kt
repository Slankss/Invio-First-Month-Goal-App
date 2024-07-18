package com.okankkl.movieapp.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val movieId : Int,
    val backdropPath: String,
    val posterPath: String,
    val title: String,
    val movieListType: String
)

