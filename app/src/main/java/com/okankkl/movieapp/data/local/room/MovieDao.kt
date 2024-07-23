package com.okankkl.movieapp.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.okankkl.movieapp.data.local.room.entity.FavouriteEntity
import com.okankkl.movieapp.data.local.room.entity.MovieEntity

@Dao
interface MovieDao
{
    @Query("SELECT * FROM movie")
    suspend fun getMovies() : List<MovieEntity>
    
    @Upsert
    suspend fun addMovies(movieList:List<MovieEntity>)
    
    @Query("DELETE FROM movie")
    suspend fun clearMovies()
    
    @Query("SELECT * FROM favourite")
    suspend fun getFavourites() : List<FavouriteEntity>
    
    @Insert
    suspend fun addFavourite(favouriteEntity: FavouriteEntity)
    
    @Query("DELETE FROM favourite WHERE id = :movieId")
    suspend fun deleteFavourite(movieId: Int)
    
    @Query("SELECT COUNT(*) FROM favourite WHERE id = :movieId")
    suspend fun isMovieInFavourites(movieId : Int) : Int
}
