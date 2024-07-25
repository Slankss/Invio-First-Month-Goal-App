package com.okankkl.movieapp.ui.screen.movie_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okankkl.movieapp.data.local.room.entity.FavouriteEntity
import com.okankkl.movieapp.domain.model.Movie
import com.okankkl.movieapp.domain.repository.MovieRepository
import com.okankkl.movieapp.ui.screen.home.HomeState
import com.okankkl.movieapp.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailFragmentViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel()
{
    private var _state = MutableStateFlow(MovieDetailState())
    var state = _state.asStateFlow()
    
    private var _similarMovies = MutableStateFlow<List<Movie>>(emptyList())
    var similarMovies = _similarMovies.asStateFlow()
    
    fun getMovieDetail(movieId: Int) = viewModelScope.launch(Dispatchers.IO) {
        _state.update { MovieDetailState(isLoading = true) }
        val result = movieRepository.getMovieDetail(movieId)
        if(result is Result.Success){
            _state.update {
                MovieDetailState(result.data)
            }
        } else {
            _state.update {
                MovieDetailState(errorMessage = (result as Result.Error).message)
            }
        }
    }
    
    fun getSimilarMovies(movieId: Int) = viewModelScope.launch(Dispatchers.IO) {
        val result = movieRepository.getSimilarMovies(movieId)
        if(result is Result.Success){
            _state.update {
                state.value.copy(
                    similarMovies = result.data
                )
            }
        } else{
            _state.update {
                state.value.copy(
                    similarMovies = null
                )
            }
        }
    }
    
    fun addFavorite(movieId: Int,title: String,posterPath:String,backdropPath: String
    ) = viewModelScope.launch(Dispatchers.IO) {
        val favourite = FavouriteEntity(movieId,backdropPath,posterPath,title)
        movieRepository.addFavourite(favourite)
    }
    fun deleteFavourite(movieId: Int) = viewModelScope.launch(Dispatchers.IO) {
        movieRepository.deleteFavourite(movieId)
    }
    fun clearState() {
        //_state.update { Result.Initial() }
    }
}