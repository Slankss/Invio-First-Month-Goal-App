package com.okankkl.movieapp.ui.screen.home
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okankkl.movieapp.data.model.Category
import com.okankkl.movieapp.data.model.Movie
import com.okankkl.movieapp.data.repository.MovieRepository
import com.okankkl.movieapp.data.repository.PreferenceRepository
import com.okankkl.movieapp.util.MovieListType
import com.okankkl.movieapp.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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
    
    fun loadMovies() = viewModelScope.launch {
        _state.update { HomeState(isLoading = true) }
        // Application is started get data from api,
        // when users in application if change screen and return the home page
        // get updateTime for get data from where
        val updateTimeStr = preferenceRepository.getMovieUpdateTime()
        val currentDate = LocalDateTime.now()
        if(updateTimeStr.isNullOrEmpty()){
            // First time application is started
            // get data from api
            val movieList = getMoviesFromApi()
            val categoryList = convertMovieListToCategoryList(movieList.await())
            _state.update { HomeState(categoryList) }
            // then add data to room database
            movieRepository.clearMovieListFromRoom()
            movieRepository.addMovieListToRoom(movieList.await())
            preferenceRepository.saveMovieUpdateTime(currentDate.toString())
        } else {
            val updateTime = LocalDateTime.parse(updateTimeStr)
            val difference = updateTime.until(currentDate, ChronoUnit.MINUTES)
            if(difference >= 10){
                // The difference is more than 10 minutes then get data from api
                val movieList = getMoviesFromApi()
                val categoryList = convertMovieListToCategoryList(movieList.await())
                _state.update { HomeState(categoryList) }
                
                // then clear room database and add data to room database
                movieRepository.clearMovieListFromRoom()
                movieRepository.addMovieListToRoom(movieList.await())
                preferenceRepository.saveMovieUpdateTime(currentDate.toString())
            } else {
                // The difference is less than 10 minutes then get data from room database
                val result = getMoviesFromRoom()
                
                _state.update {
                    when(result){
                        is Result.Success -> {
                            val categoryList = convertMovieListToCategoryList(result.data)
                            HomeState(categoryList)
                        }
                        is Result.Error -> HomeState(errorMessage = result.message)
                    }
                }
            }
        }
    }
    
    private suspend fun getMoviesFromApi() : Deferred<List<Movie>> = viewModelScope.async{
        val popularMovies = async { movieRepository.getMovieListFromApi(MovieListType.Popular,1) }
        val nowPlayingMovies = async { movieRepository.getMovieListFromApi(MovieListType.NowPlaying,1) }
        val upcomingMovies = async { movieRepository.getMovieListFromApi(MovieListType.Upcoming,1) }
        val topRatedMovies = async { movieRepository.getMovieListFromApi(MovieListType.TopRated,1) }
        
        val mergedList = mutableListOf<Movie>()
        if(popularMovies.await() is Result.Success){
            mergedList += (popularMovies.await() as Result.Success).data
        }
        if(nowPlayingMovies.await() is Result.Success){
            mergedList += (nowPlayingMovies.await() as Result.Success).data
        }
        if(upcomingMovies.await() is Result.Success){
            mergedList += (upcomingMovies.await() as Result.Success).data
        }
        if(topRatedMovies.await() is Result.Success){
            mergedList += (topRatedMovies.await() as Result.Success).data
        }
        return@async mergedList
    }
    
    private suspend fun getMoviesFromRoom() : Result<List<Movie>> {
        return movieRepository.getMovieListFromRoom()
    }
    
    fun clearState(){
        //_state.update { Result.Initial() }
    }
    
    private fun convertMovieListToCategoryList(movieList: List<Movie>) : List<Category> {
        val movieGroupList = movieList.groupBy { it.movieListType }
        
        var categoryList = listOf<Category>()
        movieGroupList.forEach {
            if(it.key != null){
                val category = Category(it.key!!,it.value)
                categoryList = categoryList + category
            }
        }
        return categoryList
    }
}