package com.okankkl.movieapp.ui.home_screen
import android.util.Log
import androidx.appcompat.widget.AppCompatRatingBar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okankkl.movieapp.data.mappers.toMovieEntity
import com.okankkl.movieapp.domain.model.Movie
import com.okankkl.movieapp.domain.repository.MovieRepository
import com.okankkl.movieapp.domain.repository.PreferenceRepository
import com.okankkl.movieapp.util.MovieListType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
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
    private var _state = MutableStateFlow(HomeState())
    var state = _state.asStateFlow()
    
    fun getMovies(){
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = HomeState(isLoading = true)
            val updateTimeStr = preferenceRepository.getMovieUpdateTime()
            val currentDate = LocalDateTime.now()
            if(updateTimeStr.isNullOrEmpty()){
                Log.d("MOVIES","UPDATE TIME NULL OR EMPTY DATA GETS FROM API")
                getMoviesFromApi()
                preferenceRepository.saveMovieUpdateTime(currentDate.toString())
            } else {
                val updateTime = LocalDateTime.parse(updateTimeStr)
                val difference = updateTime.until(currentDate, ChronoUnit.MINUTES)
                if(difference >= 10){
                    Log.d("MOVIES","DATA GETS FROM API")
                    getMoviesFromApi()
                    preferenceRepository.saveMovieUpdateTime(currentDate.toString())
                } else {
                    Log.d("MOVIES","DATA GETS FROM ROOM")
                    getMoviesFromRoom()
                }
            }
        }
    }
    
    private suspend fun getMoviesFromApi() {
        viewModelScope.launch {
            val popularMovies = async { movieRepository.getMovieListFromApi(MovieListType.Popular,1) }
            val nowPlayingMovies = async { movieRepository.getMovieListFromApi(MovieListType.NowPlaying,1) }
            val upcomingMovies = async { movieRepository.getMovieListFromApi(MovieListType.Upcoming,1) }
            val topRatedMovies = async { movieRepository.getMovieListFromApi(MovieListType.TopRated,1) }
            
            val mergeList = popularMovies.await() + nowPlayingMovies.await() + upcomingMovies.await() +
                    topRatedMovies.await()
            _state.update { HomeState(contentList = mergeList) }
        }
    }
    
    suspend fun clearMoviesFromRoom(){
        movieRepository.clearMovieListFromRoom()
    }
    
    suspend fun addMoviesToRoom(){
        val movieList = _state.value.contentList
        movieRepository.addMovieListToRoom(movieList)
    }
    
    private suspend fun getMoviesFromRoom(){
        val mappedList = movieRepository.getMovieListFromRoom().first()
        _state.update {
            HomeState(contentList = mappedList)
        }
    }
}