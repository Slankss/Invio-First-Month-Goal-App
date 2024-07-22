package com.okankkl.movieapp.ui.screen.movie_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okankkl.movieapp.data.local.room.entity.FavouriteEntity
import com.okankkl.movieapp.domain.model.Movie
import com.okankkl.movieapp.domain.repository.MovieRepository
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
    private var _state = MutableStateFlow<Result<Movie>>(Result.Loading())
    var state = _state.asStateFlow()
    
    private var _similarMovies = MutableStateFlow<List<Movie>>(emptyList())
    var similarMovies = _similarMovies.asStateFlow()
    
    fun getMovieDetail(movieId: Int){
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { Result.Loading(isLoading = true) }
            try{
                val data = movieRepository.getMovieDetail(movieId)
                data.isMovieInFavourite = movieRepository.isMovieInFavourites(movieId)
                _state.update { Result.Success(data) }
            } catch(e: Exception){
                _state.update { Result.Error(message = e.localizedMessage ?: "Unknown Error!") }
            }
        }
    }
    
    fun getSimilarMovies(movieId: Int){
        viewModelScope.launch(Dispatchers.IO) {
            try
            {
                _similarMovies.update { movieRepository.getSimilarMovies(movieId) }
            } catch(_ : Exception){}
        }
    }
    
    fun addFavorite(movieId: Int,title: String,posterPath:String,backdropPath: String){
        val favourite = FavouriteEntity(movieId,title,posterPath,backdropPath)
        viewModelScope.launch(Dispatchers.IO) {
            movieRepository.addFavourite(favourite)
        }
    }
    fun deleteFavourite(movieId: Int){
        viewModelScope.launch(Dispatchers.IO) {
            movieRepository.deleteFavourite(movieId)
        }
    }
}