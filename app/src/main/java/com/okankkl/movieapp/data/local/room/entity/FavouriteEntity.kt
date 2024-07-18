package com.okankkl.movieapp.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import retrofit2.http.Path

@Entity(tableName = "favourite")
class FavouriteEntity(
    @PrimaryKey
    val id : String,
    val backdropPath: String,
    val posterPath: String,
    val title: String,
)