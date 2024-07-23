package com.okankkl.movieapp.domain.repository

import com.okankkl.movieapp.data.local.room.entity.FavouriteEntity
import com.okankkl.movieapp.data.remote.dto.MovieResponseDto
import com.okankkl.movieapp.domain.model.Movie
import com.okankkl.movieapp.util.MovieListType
import kotlinx.coroutines.flow.Flow

interface MovieRepository
{
    suspend fun getMovieListFromApi(movieListType: MovieListType, page : Int) : List<Movie>
    
    suspend fun getMovieListFromRoom() : List<Movie>
    
    suspend fun addMovieListToRoom(movieList: List<Movie>)
    
    suspend fun clearMovieListFromRoom()
    
    suspend fun getMovieDetail(movieId: Int) : Movie
    
    suspend fun getSimilarMovies(movieId: Int) : List<Movie>
    
    suspend fun getFavouritesList() : List<FavouriteEntity>
    
    suspend fun addFavourite(favouriteEntity: FavouriteEntity)
    
    suspend fun deleteFavourite(movieId: Int)
    
    suspend fun isMovieInFavourites(movieId: Int) : Boolean
    
    suspend fun searchMovies(searchQuery: String,page: Int) : MovieResponseDto
    
    suspend fun loadMovies(movieListType: String, page: Int) : MovieResponseDto
    
    
}