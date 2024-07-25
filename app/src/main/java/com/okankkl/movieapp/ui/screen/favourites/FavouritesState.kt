package com.okankkl.movieapp.ui.screen.favourites

import com.okankkl.movieapp.data.local.room.entity.FavouriteEntity

data class FavouritesState(
    var favourites : List<FavouriteEntity>? = null,
    var isLoading : Boolean = false,
    var errorMessage : String = ""
)
