package com.okankkl.movieapp.data.repository

import com.okankkl.movieapp.data.local.room.entity.FavouriteEntity
import com.okankkl.movieapp.data.remote.dto.MovieResponseDto
import com.okankkl.movieapp.data.model.Movie
import com.okankkl.movieapp.util.Result

interface MovieRepository
{
    suspend fun getMoviesList() : Result<List<Movie>>
    
    suspend fun addMovieListToRoom(movieList: List<Movie>)
    
    suspend fun clearMovieListFromRoom()
    
    suspend fun getMovieDetail(movieId: Int) : Result<Movie>
    
    suspend fun getSimilarMovies(movieId: Int) : Result<List<Movie>>
    
    suspend fun getFavouritesList() : Result<List<FavouriteEntity>>
    
    suspend fun addFavourite(favouriteEntity: FavouriteEntity)
    
    suspend fun deleteFavourite(movieId: Int)
    
    suspend fun isMovieInFavourites(movieId: Int) : Boolean
    
    suspend fun searchMovies(searchQuery: String,page: Int) : Result<MovieResponseDto>
    
    suspend fun loadMovies(movieListType: String, page: Int) : Result<MovieResponseDto>
    
    
}