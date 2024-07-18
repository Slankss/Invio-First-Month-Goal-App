package com.okankkl.movieapp.data.repository
import android.util.Log
import com.okankkl.movieapp.data.local.room.database.MovieDao
import com.okankkl.movieapp.data.local.room.entity.MovieEntity
import com.okankkl.movieapp.data.mappers.toMovie
import com.okankkl.movieapp.data.mappers.toMovieEntity
import com.okankkl.movieapp.data.remote.MovieApi
import com.okankkl.movieapp.domain.model.Movie
import com.okankkl.movieapp.domain.repository.MovieRepository
import com.okankkl.movieapp.util.MovieListType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
        private val movieApi: MovieApi, private val movieDao: MovieDao)
    : MovieRepository
{
    override suspend fun getMovieListFromApi(movieListType: MovieListType, page: Int): List<Movie> {
      return try {
          movieApi.getMovies(movieListType.routeName,page = page).results.map { movieDto ->
            movieDto.toMovie(movieListType)
          }
        } catch(e: Exception){
          emptyList()
        }
    }
    
    override suspend fun getMovieListFromRoom(): Flow<List<Movie>> {
        return movieDao.getMovies().map { movieList ->
                movieList.map { movieEntity ->
                    movieEntity.toMovie()
                }
        }
    }
    
    override suspend fun addMovieListToRoom(movieList: List<Movie>)
    {
        try
        {
            val mappedList = movieList.map { movie ->
                movie.toMovieEntity()
            }
            movieDao.addMovies(mappedList)
            
        } catch(_: Exception){ }
    }
    
    override suspend fun clearMovieListFromRoom()
    {
        movieDao.clearMovies()
    }
}