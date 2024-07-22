package com.okankkl.movieapp.ui.screen.viewall

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okankkl.movieapp.data.mappers.toMovie
import com.okankkl.movieapp.domain.model.Movie
import com.okankkl.movieapp.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ViewAllState(
    val data: List<Movie>? = null,
    val isLoading: Boolean = false,
    val errorMessage: String = ""
)

@HiltViewModel
class ViewAllFragmentViewModel @Inject constructor(
    private val movieRepository: MovieRepository
): ViewModel()
{
    private var _state = MutableStateFlow(ViewAllState())
    var state = _state.asStateFlow()
    var currentPage = 1
    var totalPage = 0
    
    fun loadMovies(movieListTypeRouteName : String){
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { ViewAllState(isLoading = true) }
            if(currentPage == 1){
                val movies = movieRepository.loadMovies(movieListTypeRouteName,currentPage).results.map { it.toMovie() }
                _state.update { ViewAllState(data = movies) }
            }
            else if(currentPage < totalPage){
                val movies = movieRepository.loadMovies(movieListTypeRouteName,currentPage).results.map { it.toMovie() }
                _state.update {
                    ViewAllState(
                        data = _state.value.data!! + movies
                    )
                }
            } else {
                // page is over
            }
            currentPage++
        }
    }
}