package com.okankkl.movieapp.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "watch_list")
data class WatchListEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)
