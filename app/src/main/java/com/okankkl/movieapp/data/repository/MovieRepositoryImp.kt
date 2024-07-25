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
import retrofit2.HttpException
import javax.inject.Inject
import com.okankkl.movieapp.util.Result

class MovieRepositoryImp @Inject constructor(
        private val movieApi: MovieApi, private val movieDao: MovieDao
)
    : MovieRepository
{
    override suspend fun getMovieListFromApi(movieListType: MovieListType, page: Int): Result<List<Movie>> {
        return try {
            val response = movieApi.getMovies(movieListType.routeName,page)
            if(response.results.isNullOrEmpty()){
                Result.Error("There is no data")
            } else {
                val movies = response.results
                    .map { it.toMovie(movieListType) }
                    .filter { it.posterPath.isNotEmpty() || it.backdropPath.isNotEmpty() }
                Result.Success(movies)
            }
        } catch(e : HttpException){
            Result.Error(e.localizedMessage ?: "Error")
        }
    }
    
    override suspend fun getMovieListFromRoom(): Result<List<Movie>> {
       return try{
           val movies = movieDao.getMovies().map { it.toMovie() }
           if(movies.isEmpty()){
               Result.Error("There is no data")
           } else {
               Result.Success(movies)
           }
       } catch(e: Exception){
           Result.Error(e.localizedMessage ?: "Error")
       }
    }
    
    override suspend fun addMovieListToRoom(movieList: List<Movie>) {
        val mappedList = movieList.map { movie ->
            movie.toMovieEntity() }
        movieDao.addMovies(mappedList)
    }
    
    override suspend fun clearMovieListFromRoom() {
        movieDao.clearMovies()
    }
    
    override suspend fun getMovieDetail(movieId: Int): Result<Movie> {
        return try {
            val movie = movieApi.getMovieDetail(movieId).toMovie()
            Result.Success(movie)
        } catch(e: HttpException){
            Result.Error(e.localizedMessage ?: "Error")
        }
    }
    
    override suspend fun getSimilarMovies(movieId: Int): Result<List<Movie>> {
        return try {
            val similarMovies = movieApi.getSimilarMovies(movieId).results
            if(similarMovies.isNullOrEmpty()){
                Result.Error("There is no data")
            } else {
                val filteredSimilarMovies = similarMovies
                    .filter { !it.posterPath.isNullOrEmpty() || !it.backdropPath.isNullOrEmpty()}
                    .map { it.toMovie() }
                Result.Success(filteredSimilarMovies)
            }
        } catch(e : HttpException){
            Result.Error(e.localizedMessage ?: "Error")
        }
    }
    
    override suspend fun getFavouritesList(): Result<List<FavouriteEntity>> {
        return try {
            val favourites = movieDao.getFavourites()
            if(favourites.isEmpty()){
                Result.Error("There is no data")
            } else {
                Result.Success(favourites)
            }
        } catch(e : Exception){
            Result.Error(e.localizedMessage ?: "Error")
        }
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
    
    override suspend fun searchMovies(searchQuery: String,page: Int) : Result<MovieResponseDto> {
        return try {
            val response = movieApi.searchMovie(searchQuery,page)
            
            if(response.results.isNullOrEmpty()){
                Result.Error("There is no data")
            } else {
                Result.Success(response)
            }
        } catch(e : HttpException){
            Result.Error(e.localizedMessage ?: "Error")
        }
    }
    
    override suspend fun loadMovies(movieListType: String, page: Int): Result<MovieResponseDto> {
        return try {
            val response = movieApi.getMovies(movieListType,page)
            
            if(response.results.isNullOrEmpty()){
                Result.Error("There is no data")
            } else {
                Result.Success(response)
            }
        } catch(e : HttpException){
            Result.Error(e.localizedMessage ?: "Error")
        }
    }
}