package com.okankkl.movieapp.ui.screen.search
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
class SearchFragmentViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel()
{
    private var _state = MutableStateFlow<List<Movie>>(emptyList())
    val state = _state.asStateFlow()
    private var currentPage = 1
    private var totalPage = 0
    var moviePageSize = 20
    
    fun searchMovies(searchQuery: String) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val data = movieRepository.searchMovies(searchQuery,currentPage)
            val movies = data.results
                .map { it.toMovie() }
                .filter { it.posterPath.isNotEmpty() || it.backdropPath.isNotEmpty() }
            totalPage = data.total_pages
            moviePageSize = movies.size
            if(currentPage < totalPage){
                _state.update {
                    when(currentPage){
                        1 -> movies
                        else -> _state.value + movies
                    }
                }
            }
            currentPage++
        } catch(_ : Exception){}
    }
    
    fun setCurrentPage(pageNumber: Int){
        currentPage = pageNumber
    }
}