package com.okankkl.movieapp.ui.screen.viewall

import android.util.Log
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

@HiltViewModel
class ViewAllFragmentViewModel @Inject constructor(
    private val movieRepository: MovieRepository
): ViewModel()
{
    private var _state = MutableStateFlow<List<Movie>>(emptyList())
    var state = _state.asStateFlow()
    var currentPage = 1 // pagination starts 1
    var totalPage = 0 // get first page data and set totalPage
    var moviePageSize = 20 // get each page data size and set moviePageSize
    
    fun loadMovies(movieListTypeRouteName : String) = viewModelScope.launch(Dispatchers.IO) {
        try {
            if(currentPage == 1){
                val data = movieRepository.loadMovies(movieListTypeRouteName,currentPage)
                val movies = data.results
                    .map { it.toMovie() }
                    .filter { it.backdropPath.isNotEmpty() || it.posterPath.isNotEmpty() }
                moviePageSize = movies.size
                totalPage = data.total_pages
                _state.update { movies }
            }
            else if(currentPage < totalPage){
                val movies = movieRepository.loadMovies(movieListTypeRouteName,currentPage).results
                    .map { it.toMovie() }
                    .filter { it.posterPath.isNotEmpty() || it.backdropPath.isNotEmpty() }
                moviePageSize = movies.size
                _state.update { _state.value + movies }
            }
            currentPage++
        } catch(_ : Exception){}
    }
    
    fun clearState(){
        _state.update { emptyList() }
    }
}