package com.okankkl.movieapp.data.local.room.database

import androidx.room.Dao
import androidx.room.DeleteTable
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.okankkl.movieapp.data.local.room.entity.FavouriteEntity
import com.okankkl.movieapp.data.local.room.entity.MovieEntity
import com.okankkl.movieapp.data.local.room.entity.WatchListEntity
import com.okankkl.movieapp.data.local.room.entity.WatchListMoviesEntity

@Dao
interface MovieDao
{
    @Query("SELECT * FROM movie")
    fun getMovies() : List<MovieEntity>
    
    @Upsert
    suspend fun addMovies(movieList:List<MovieEntity>)
    
    @Query("DELETE FROM movie")
    suspend fun clearMovies()
    
    @Query("SELECT * FROM favourite")
    fun getFavourites() : List<FavouriteEntity>
    
    @Insert
    suspend fun addFavourite(favouriteEntity: FavouriteEntity)
    
    @Query("DELETE FROM favourite WHERE id = :movieId")
    suspend fun deleteFavourite(movieId: Int)
    
    @Query("SELECT COUNT(*) FROM favourite WHERE id = :movieId")
    fun isMovieInFavourites(movieId : Int) : Int
}
