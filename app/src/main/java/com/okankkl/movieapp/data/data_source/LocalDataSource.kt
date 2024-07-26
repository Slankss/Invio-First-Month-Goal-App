package com.okankkl.movieapp.data.data_source

import com.okankkl.movieapp.data.local.room.MovieDao
import com.okankkl.movieapp.data.local.room.entity.FavouriteEntity
import com.okankkl.movieapp.data.local.room.entity.MovieEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val movieDao: MovieDao)
{
    
    suspend fun getMovieList() : List<MovieEntity> {
        return movieDao.getMovies()
    }
    
    suspend fun addMovieList(movieList: List<MovieEntity>){
        movieDao.addMovies(movieList)
    }
    
    suspend fun clearMovieList(){
        movieDao.clearMovies()
    }
    
    suspend fun getFavouriteList() : List<FavouriteEntity>{
        return movieDao.getFavourites()
    }
    
    suspend fun addFavourite(favouriteEntity: FavouriteEntity){
        movieDao.addFavourite(favouriteEntity)
    }
    
    suspend fun deleteFavourite(movieId: Int){
        movieDao.deleteFavourite(movieId)
    }
    
    suspend fun isMovieInFavourites(movieId: Int) : Boolean{
        return movieDao.isMovieInFavourites(movieId) == 1
    }
}