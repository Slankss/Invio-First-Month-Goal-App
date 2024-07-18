package com.okankkl.movieapp.domain.repository

import com.okankkl.movieapp.data.local.room.entity.MovieEntity
import com.okankkl.movieapp.domain.model.Movie
import com.okankkl.movieapp.util.MovieListType
import kotlinx.coroutines.flow.Flow

interface MovieRepository
{
    suspend fun getMovieListFromApi(movieListType: MovieListType, page : Int) : List<Movie>
    
    suspend fun getMovieListFromRoom() : Flow<List<Movie>>
    
    suspend fun addMovieListToRoom(movieList: List<Movie>)
    
    suspend fun clearMovieListFromRoom()
}