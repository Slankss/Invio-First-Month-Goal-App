package com.okankkl.movieapp.data.repository
import com.okankkl.movieapp.data.data_source.DataStoreManager
import com.okankkl.movieapp.data.data_source.LocalDataSource
import com.okankkl.movieapp.data.data_source.RemoteDataSource
import com.okankkl.movieapp.data.local.room.entity.FavouriteEntity
import com.okankkl.movieapp.data.mappers.toMovie
import com.okankkl.movieapp.data.mappers.toMovieEntity
import com.okankkl.movieapp.data.remote.dto.MovieResponseDto
import com.okankkl.movieapp.data.model.Movie
import retrofit2.HttpException
import javax.inject.Inject
import com.okankkl.movieapp.util.Result
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class MovieRepositoryImp @Inject constructor(
        private val dataStoreManager: DataStoreManager,
        private val localDataSource: LocalDataSource,
        private val remoteDataSource: RemoteDataSource,
)
    : MovieRepository
{
    override suspend fun getMoviesList(): Result<List<Movie>> {
        return try {
            val updateTimeStr = dataStoreManager.getMoviesUpdateTime()
            val currentDate = LocalDateTime.now()
            if(updateTimeStr.isNullOrEmpty()){
                // Get data from remote
                val movieList = remoteDataSource.getAllMovies().await()
                val movieEntityList = movieList.map { it.toMovieEntity() }
                localDataSource.clearMovieList()
                localDataSource.addMovieList(movieEntityList)
                dataStoreManager.saveUpdateTime(currentDate.toString())
                Result.Success(movieList)
            }
            else{
                val updateTime = LocalDateTime.parse(updateTimeStr)
                val difference = updateTime.until(currentDate,ChronoUnit.MINUTES)
                
                if(difference >= 10){
                    // Get data from api
                    val movieList = remoteDataSource.getAllMovies().await()
                    val movieEntityList = movieList.map { it.toMovieEntity() }
                    localDataSource.clearMovieList()
                    localDataSource.addMovieList(movieEntityList)
                    dataStoreManager.saveUpdateTime(currentDate.toString())
                    Result.Success(movieList)
                } else{
                    // Get data from room
                    val movieList = localDataSource.getMovieList()
                        .map { it.toMovie() }
                    Result.Success(movieList)
                }
            }
        } catch(e : Exception){
            Result.Error(message = e.localizedMessage ?: "Unexpected error!")
        }
    }
    
    override suspend fun addMovieListToRoom(movieList: List<Movie>) {
        val movieEntityList = movieList.map { it.toMovieEntity() }
        localDataSource.addMovieList(movieEntityList)
    }
    
    override suspend fun clearMovieListFromRoom() {
        localDataSource.clearMovieList()
    }
    
    override suspend fun getMovieDetail(movieId: Int): Result<Movie> {
        return try {
            val movie = remoteDataSource.getMovieDetail(movieId).toMovie()
            Result.Success(movie)
        } catch(e: HttpException){
            Result.Error(e.localizedMessage ?: "Error")
        }
    }
    
    override suspend fun getSimilarMovies(movieId: Int): Result<List<Movie>> {
        return try {
            
            val similarMovies = remoteDataSource.getSimilarMovies(movieId)
                .map { it.toMovie() }
                .filter { it.posterPath.isNotEmpty() || it.backdropPath.isNotEmpty() }
            
            if(similarMovies.isNotEmpty()){
                Result.Success(similarMovies)
            } else {
                Result.Error("There is no data")
            }
        } catch(e : HttpException){
            Result.Error(e.localizedMessage ?: "Error")
        }
    }
    
    override suspend fun getFavouritesList(): Result<List<FavouriteEntity>> {
        return try {
            val favourites = localDataSource.getFavouriteList()
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
        localDataSource.addFavourite(favouriteEntity)
    }
    
    override suspend fun deleteFavourite(movieId: Int) {
        localDataSource.deleteFavourite(movieId)
    }
    
    override suspend fun isMovieInFavourites(movieId: Int): Boolean {
        return localDataSource.isMovieInFavourites(movieId)
    }
    
    override suspend fun searchMovies(searchQuery: String,page: Int) : Result<MovieResponseDto> {
        return try {
            val response = remoteDataSource.searchMovie(searchQuery,page)
            
            if(response.results.isEmpty()){
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
            val response = remoteDataSource.loadMovies(movieListType,page)
            
            if(response.results.isEmpty()){
                Result.Error("There is no data")
            } else {
                Result.Success(response)
            }
        } catch(e : HttpException){
            Result.Error(e.localizedMessage ?: "Error")
        }
    }
}