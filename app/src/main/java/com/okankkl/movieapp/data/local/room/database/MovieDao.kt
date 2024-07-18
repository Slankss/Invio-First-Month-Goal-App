package com.okankkl.movieapp.data.local.room.database

import androidx.room.Dao
import androidx.room.DeleteTable
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.okankkl.movieapp.data.local.room.entity.MovieEntity
import com.okankkl.movieapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao
{
    @Query("SELECT * FROM movie")
    fun getMovies() : Flow<List<MovieEntity>>
    
    @Upsert
    suspend fun addMovies(movieList:List<MovieEntity>)
    
    @Query("DELETE FROM movie")
    suspend fun clearMovies()
}
