package com.okankkl.movieapp.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val movieId : Int,
    @ColumnInfo(name = "backdropPath", defaultValue = "")
    val backdropPath: String?,
    @ColumnInfo(name = "posterPath", defaultValue = "")
    val posterPath: String?,
    @ColumnInfo(name = "title", defaultValue = "")
    val title: String?,
    val movieListType: String
)

