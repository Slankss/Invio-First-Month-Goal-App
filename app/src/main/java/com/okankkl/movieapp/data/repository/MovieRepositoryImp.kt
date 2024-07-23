package com.okankkl.movieapp.data.repository
import com.okankkl.movieapp.data.local.room.MovieDao
import com.okankkl.movieapp.data.local.room.entity.FavouriteEntity
import com.okankkl.movieapp.data.mappers.toMovie
import com.okankkl.movieapp.data.mappers.toMovieEntity
import com.okankkl.movieapp.data.remote.MovieApi
import com.okankkl.movieapp.data.remote.dto.MovieResponseDto
import com.okankkl.movieapp.domain.model.Movie
import com.okankkl.movieapp.domain.repository.MovieRepository
import com.okankkl.movieapp.util.MovieListType
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
        private val movieApi: MovieApi, private val movieDao: MovieDao
)
    : MovieRepository
{
    override suspend fun getMovieListFromApi(movieListType: MovieListType, page: Int): List<Movie> {
        return movieApi.getMovies(movieListType.routeName,page).results.map {
            it.toMovie(movieListType = movieListType)
        }
    }
    
    override suspend fun getMovieListFromRoom(): List<Movie> {
       return movieDao.getMovies().map { it.toMovie() }
    }
    
    override suspend fun addMovieListToRoom(movieList: List<Movie>) {
        val mappedList = movieList.map { movie ->
            movie.toMovieEntity() }
        movieDao.addMovies(mappedList)
    }
    
    override suspend fun clearMovieListFromRoom() {
        movieDao.clearMovies()
    }
    
    override suspend fun getMovieDetail(movieId: Int): Movie {
        return movieApi.getMovieDetail(movieId).toMovie()
    }
    
    override suspend fun getSimilarMovies(movieId: Int): List<Movie> {
        return movieApi.getSimilarMovies(movieId).results
            .map { it.toMovie() }
            .filter { it.posterPath.isNotEmpty() || it.backdropPath.isNotEmpty() }
    }
    
    override suspend fun getFavouritesList(): List<FavouriteEntity>
    {
        return movieDao.getFavourites()
    }
    
    override suspend fun addFavourite(favouriteEntity: FavouriteEntity) {
        movieDao.addFavourite(favouriteEntity)
    }
    
    override suspend fun deleteFavourite(movieId: Int) {
        movieDao.deleteFavourite(movieId)
    }
    
    override suspend fun isMovieInFavourites(movieId: Int): Boolean {
        return movieDao.isMovieInFavourites(movieId) == 1
    }
    
    override suspend fun searchMovies(searchQuery: String,page: Int) : MovieResponseDto {
        return movieApi.searchMovie(searchQuery,page)
    }
    
    override suspend fun loadMovies(movieListType: String, page: Int): MovieResponseDto {
        return movieApi.getMovies(movieListType,page)
    }
}