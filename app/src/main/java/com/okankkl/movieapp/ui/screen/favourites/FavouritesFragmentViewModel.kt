package com.okankkl.movieapp.ui.screen.favourites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okankkl.movieapp.data.repository.MovieRepository
import com.okankkl.movieapp.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesFragmentViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel()
{
    private var _state = MutableStateFlow(FavouritesState())
    val state = _state.asStateFlow()
    
    fun getFavouritesList() = viewModelScope.launch(Dispatchers.IO) {
        _state.update { FavouritesState(isLoading = true) }
        val result = movieRepository.getFavouritesList()
        
        if(result is Result.Success) {
            _state.update { FavouritesState(result.data) }
        } else {
            _state.update {
                FavouritesState(errorMessage = (result as Result.Error).message)
            }
        }
    }
    
    fun deleteFavourite(movieId: Int) = viewModelScope.launch(Dispatchers.IO){
        movieRepository.deleteFavourite(movieId)
        getFavouritesList()
    }
    
}