package com.okankkl.movieapp.ui.screen.home
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okankkl.movieapp.domain.model.Movie
import com.okankkl.movieapp.domain.repository.MovieRepository
import com.okankkl.movieapp.domain.repository.PreferenceRepository
import com.okankkl.movieapp.util.MovieListType
import com.okankkl.movieapp.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
        private val movieRepository: MovieRepository,
        private val preferenceRepository: PreferenceRepository
) : ViewModel()
{
    private var _state = MutableStateFlow<Result<List<Movie>>>(Result.Loading())
    var state = _state.asStateFlow()
    
    fun loadMovies(){
        viewModelScope.launch(Dispatchers.IO) {
            val updateTimeStr = preferenceRepository.getMovieUpdateTime()
            val currentDate = LocalDateTime.now()
            if(updateTimeStr.isNullOrEmpty()){
                getMoviesFromApi()
                preferenceRepository.saveMovieUpdateTime(currentDate.toString())
            } else {
                val updateTime = LocalDateTime.parse(updateTimeStr)
                val difference = updateTime.until(currentDate, ChronoUnit.MINUTES)
                if(difference >= 10){
                    getMoviesFromApi()
                    preferenceRepository.saveMovieUpdateTime(currentDate.toString())
                } else {
                    getMoviesFromRoom()
                }
            }
        }
    }
    
    private suspend fun getMoviesFromApi() {
        viewModelScope.launch {
            _state.update { Result.Loading(isLoading = true) }
            try {
                val popularMovies = async { movieRepository.getMovieListFromApi(MovieListType.Popular,1) }
                val nowPlayingMovies = async { movieRepository.getMovieListFromApi(MovieListType.NowPlaying,1) }
                val upcomingMovies = async { movieRepository.getMovieListFromApi(MovieListType.Upcoming,1) }
                val topRatedMovies = async { movieRepository.getMovieListFromApi(MovieListType.TopRated,1) }
                
                val mergedList = popularMovies.await() + nowPlayingMovies.await() + upcomingMovies.await() +
                        topRatedMovies.await()
                _state.update { Result.Success(data = mergedList) }
            } catch(e: Exception){
                _state.update { Result.Error(message = e.localizedMessage ?: "Unknown Error") }
            }
            
        }
    }
    
    suspend fun clearMoviesFromRoom(){
        movieRepository.clearMovieListFromRoom()
    }
    
    suspend fun addMoviesToRoom(){
        try {
            val movieList = (_state.value as Result.Success).data
            movieRepository.addMovieListToRoom(movieList)
        } catch(_ : Exception){}
    }
    
    private suspend fun getMoviesFromRoom(){
        _state.update { Result.Loading() }
        try {
            val mappedList = movieRepository.getMovieListFromRoom().first()
            _state.update { Result.Success(data = mappedList) }
        } catch(e: Exception){
            _state.update { Result.Error(message = e.localizedMessage ?: "Unknown Error") }
        }
       
    }
}