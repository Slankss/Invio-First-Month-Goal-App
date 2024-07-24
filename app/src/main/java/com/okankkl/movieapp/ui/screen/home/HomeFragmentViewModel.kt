package com.okankkl.movieapp.ui.screen.home
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okankkl.movieapp.domain.model.Movie
import com.okankkl.movieapp.domain.repository.MovieRepository
import com.okankkl.movieapp.domain.repository.PreferenceRepository
import com.okankkl.movieapp.util.MovieListType
import com.okankkl.movieapp.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
        private val movieRepository: MovieRepository,
        private val preferenceRepository: PreferenceRepository
) : ViewModel()
{
    private var _state = MutableStateFlow<Result<List<Movie>>>(Result.Initial())
    var state = _state.asStateFlow()
    
    fun loadMovies() = viewModelScope.launch{
        try {
            // Application is started get data from api,
            // when users in application if change screen and return the home page
            // then application will get data from room database if updateTime is less than 10 minutes
            // if updateTime is more than 10 minutes then application will get data from api
            val updateTimeStr = preferenceRepository.getMovieUpdateTime()
            val currentDate = LocalDateTime.now()
            if(updateTimeStr.isNullOrEmpty()){
                // First time application is started
                // get data from api
                // then add data to room database
                val movies = getMoviesFromApi()
                _state.update { Result.Success(movies.await()) }
                movieRepository.clearMovieListFromRoom()
                movieRepository.addMovieListToRoom(movies.await())
                preferenceRepository.saveMovieUpdateTime(currentDate.toString())
            } else {
                val updateTime = LocalDateTime.parse(updateTimeStr)
                val difference = updateTime.until(currentDate, ChronoUnit.MINUTES)
                if(difference >= 10){
                    // The difference is more than 10 minutes then get data from api
                    // then clear room database and add data to room database
                    val movies = getMoviesFromApi()
                    _state.update { Result.Success(movies.await()) }
                    //movieRepository.clearMovieListFromRoom()
                    //movieRepository.addMovieListToRoom(movies.await())
                    preferenceRepository.saveMovieUpdateTime(currentDate.toString())
                } else {
                    // The difference is less than 10 minutes then get data from room database
                    _state.update { Result.Success(getMoviesFromRoom().await()) }
                }
            }
        } catch(e : Exception){
            _state.update { Result.Error(message = e.localizedMessage ?: "Unexpected Error!") }
        }
    }
    
    private suspend fun getMoviesFromApi() : Deferred<List<Movie>> = viewModelScope.async{
        val popularMovies = async { movieRepository.getMovieListFromApi(MovieListType.Popular,1) }
        val nowPlayingMovies = async { movieRepository.getMovieListFromApi(MovieListType.NowPlaying,1) }
        val upcomingMovies = async { movieRepository.getMovieListFromApi(MovieListType.Upcoming,1) }
        val topRatedMovies = async { movieRepository.getMovieListFromApi(MovieListType.TopRated,1) }
        
        val mergedList = popularMovies.await() + nowPlayingMovies.await() + upcomingMovies.await() +
                topRatedMovies.await()
        return@async mergedList
    }
    
    private suspend fun getMoviesFromRoom() : Deferred<List<Movie>> = viewModelScope.async{
        return@async movieRepository.getMovieListFromRoom()
    }
    
    fun clearState(){
        _state.update { Result.Initial() }
    }
}