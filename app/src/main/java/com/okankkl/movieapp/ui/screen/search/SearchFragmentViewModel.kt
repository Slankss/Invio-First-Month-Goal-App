package com.okankkl.movieapp.ui.screen.search
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okankkl.movieapp.data.mappers.toMovie
import com.okankkl.movieapp.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.okankkl.movieapp.util.Result

@HiltViewModel
class SearchFragmentViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel()
{
    private var _state = MutableStateFlow(SearchState())
    val state = _state.asStateFlow()
    
    fun searchMovies(searchQuery: String) = viewModelScope.launch(Dispatchers.IO) {
       _state.update { SearchState(isLoading = true) }
        
        val result = movieRepository.searchMovies(searchQuery,state.value.currentPage)
        
        if(result is Result.Success){
            // I guaranteed that result.data.results is not null
            // because I controlled results in repository
            val movies = result.data.results!!
                .map { it.toMovie() }
                .filter { it.posterPath.isNotEmpty() || it.backdropPath.isNotEmpty() }
            
            if(state.value.currentPage == 1){
                _state.update { SearchState(movies) }
            } else {
                val recentMovies = state.value.movies ?: emptyList()
                _state.update {
                    state.value.copy(
                        movies = recentMovies + movies,
                        currentPage = state.value.currentPage + 1
                    )
                }
            }
        } else {
            if(state.value.movies.isNullOrEmpty()){
                _state.update { SearchState(errorMessage = (result as Result.Error).message) }
            } // if there is data in state there is no need to show error message
        }
    }
    
    fun setCurrentPage(pageNumber: Int){
        _state.update { state.value.copy(currentPage = pageNumber) }
    }
}