package com.okankkl.movieapp.ui.screen.search
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    
    fun searchMovies(searchQuery: String){
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { movieRepository.searchMovies(searchQuery,1) }
        }
    }
    
}