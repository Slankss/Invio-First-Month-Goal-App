package com.okankkl.movieapp.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite")
data class FavouriteEntity(
    @PrimaryKey
    val id : Int,
    val backdropPath: String,
    val posterPath: String,
    val title: String,
)