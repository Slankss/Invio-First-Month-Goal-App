package com.okankkl.movieapp.ui.screen.favourites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okankkl.movieapp.data.local.room.entity.FavouriteEntity
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
class FavouritesFragmentViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel()
{
    private var _state = MutableStateFlow<Result<List<FavouriteEntity>>>(Result.Loading())
    val state = _state.asStateFlow()
    
    suspend fun getFavouritesList(){
        viewModelScope.launch(Dispatchers.IO) {
        try {
            _state.update { Result.Loading() }
            val data = movieRepository.getFavouritesList()
            
            if(data.isEmpty()){
                _state.update { Result.Error("There is no data") }
            } else {
                _state.update { Result.Success(data = data) }
            }
        } catch(_ : Exception){
            _state.update { Result.Error("Error") }
            }
        }
    }
    
    fun deleteFavourite(movieId: Int){
        viewModelScope.launch {
            movieRepository.deleteFavourite(movieId)
            getFavouritesList()
        }
    }
}