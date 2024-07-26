package com.okankkl.movieapp.data.data_source

import com.okankkl.movieapp.data.mappers.toMovie
import com.okankkl.movieapp.data.model.Movie
import com.okankkl.movieapp.data.remote.MovieApi
import com.okankkl.movieapp.data.remote.dto.MovieDetailDto
import com.okankkl.movieapp.data.remote.dto.MovieDto
import com.okankkl.movieapp.data.remote.dto.MovieResponseDto
import com.okankkl.movieapp.util.MovieListType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val movieApi: MovieApi
)
{
    suspend fun getAllMovies() : Deferred<List<Movie>>
    = CoroutineScope(Dispatchers.IO).async{
            val popularMovies = async { movieApi.getMovies(MovieListType.Popular.routeName,1) }
            val nowPlayingMovies = async { movieApi.getMovies(MovieListType.NowPlaying.routeName,1) }
            val upcomingMovies = async { movieApi.getMovies(MovieListType.Upcoming.routeName,1) }
            val topRatedMovies = async { movieApi.getMovies(MovieListType.TopRated.routeName,1) }
            
            val mergedList = mutableListOf<Movie>()
            
            mergedList += popularMovies.await().results.map { it.toMovie(MovieListType.Popular) }
            mergedList += nowPlayingMovies.await().results.map { it.toMovie(MovieListType.NowPlaying) }
            mergedList += upcomingMovies.await().results.map { it.toMovie(MovieListType.Upcoming) }
            mergedList += topRatedMovies.await().results.map { it.toMovie(MovieListType.TopRated) }
        
            return@async mergedList.toList()
    }
    
    suspend fun loadMovies(movieListType : String,page : Int)
    : MovieResponseDto{
        return movieApi.getMovies(movieListType,page)
    }
    
    suspend fun getMovieDetail(movieId : Int) : MovieDetailDto{
        return movieApi.getMovieDetail(movieId)
    }
    
    suspend fun getSimilarMovies(movieId: Int) : List<MovieDto>{
        return movieApi.getSimilarMovies(movieId).results
    }
    
    suspend fun searchMovie(searchQuery : String,page: Int) : MovieResponseDto{
        return movieApi.searchMovie(searchQuery,page)
    }

}