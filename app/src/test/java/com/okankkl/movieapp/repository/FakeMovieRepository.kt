package com.okankkl.movieapp.repository

import com.okankkl.movieapp.data.local.room.entity.FavouriteEntity
import com.okankkl.movieapp.domain.model.Movie
import com.okankkl.movieapp.domain.repository.MovieRepository
import com.okankkl.movieapp.util.MovieListType
import kotlinx.coroutines.flow.Flow

class FakeMovieRepository : MovieRepository
{
    private var movieList = mutableListOf<Movie>(
        Movie(1, "title1", "posterPath1", "backdropPath1"),
        Movie(2, "title2", "", "backdropPath2"),
        Movie(3, "title3", "posterPath3", ""),
        Movie(4, "title4", "", "")
    )
    
    override suspend fun getMovieListFromApi(movieListType: MovieListType, page: Int): List<Movie>
    {
        return movieList.filter { it.backdropPath.isNotEmpty() || it.posterPath.isNotEmpty() }
    }
    
    override suspend fun getMovieListFromRoom(): Flow<List<Movie>>
    {
        TODO("Not yet implemented")
    }
    
    override suspend fun addMovieListToRoom(movieList: List<Movie>)
    {
        TODO("Not yet implemented")
    }
    
    override suspend fun clearMovieListFromRoom()
    {
        TODO("Not yet implemented")
    }
    
    override suspend fun getMovieDetail(movieId: Int): Movie
    {
        TODO("Not yet implemented")
    }
    
    override suspend fun getSimilarMovies(movieId: Int): List<Movie>
    {
        return movieList.filter { it.backdropPath.isNotEmpty() || it.posterPath.isNotEmpty() }
    }
    
    override suspend fun addFavourite(favouriteEntity: FavouriteEntity)
    {
        TODO("Not yet implemented")
    }
    
    override suspend fun deleteFavourite(movieId: Int)
    {
        TODO("Not yet implemented")
    }
}