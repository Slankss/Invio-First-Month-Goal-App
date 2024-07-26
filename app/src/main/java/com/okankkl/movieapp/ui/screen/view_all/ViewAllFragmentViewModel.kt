package com.okankkl.movieapp.ui.screen.view_all

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okankkl.movieapp.data.mappers.toMovie
import com.okankkl.movieapp.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.okankkl.movieapp.util.Result

@HiltViewModel
class ViewAllFragmentViewModel @Inject constructor(
    private val movieRepository: MovieRepository
): ViewModel()
{
    private var _state = MutableStateFlow(ViewAllState())
    var state = _state.asStateFlow()
    
    fun loadMovies(movieListTypeRouteName : String) = viewModelScope.launch(Dispatchers.IO) {
        _state.update { state.value.copy(isLoading = true) }
        val result = movieRepository.loadMovies(movieListTypeRouteName,state.value.currentPage)
        if(result is Result.Success){
            val data = result.data
            val movies = data.results
                .map { it.toMovie() }
                .filter { it.posterPath.isNotEmpty() || it.backdropPath.isNotEmpty() }
                
            if(state.value.currentPage == 1){
                _state.update {
                    state.value.copy(
                        movies = movies,
                        pageSize = movies.size,
                        currentPage = state.value.currentPage + 1
                    )
                }
            } else{
                val recentMovies = state.value.movies ?: emptyList()
                _state.update{
                    state.value.copy(
                        movies = recentMovies + movies,
                        pageSize = movies.size,
                        currentPage = state.value.currentPage + 1
                    )
                }
            }
        } else if(state.value.movies.isNullOrEmpty()) {
            _state.update { ViewAllState(errorMessage = (result as Result.Error).message) }
        }
    }
    
}