package com.okankkl.movieapp.ui.screen.home
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okankkl.movieapp.data.model.Category
import com.okankkl.movieapp.data.model.Movie
import com.okankkl.movieapp.data.repository.MovieRepository
import com.okankkl.movieapp.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
        private val movieRepository: MovieRepository
) : ViewModel()
{
    private var _state = MutableStateFlow(HomeState())
    var state = _state.asStateFlow()
    
    fun getMovies() = viewModelScope.launch {
        _state.update { HomeState(isLoading = true) }
        
        val result = movieRepository.getMoviesList()
        if(result is Result.Success){
            Log.d("EMINEM","Result size = ${result.data.size}")
            val categoryList = convertMovieListToCategoryList(result.data)
            _state.update {HomeState(categoryList.await())}
        } else {
            _state.update {
                HomeState(errorMessage = (result as Result.Error).message)
            }
        }
    }
    
    private fun convertMovieListToCategoryList(movieList: List<Movie>) : Deferred<List<Category>>
     = viewModelScope.async(Dispatchers.IO){
        val movieGroupList = movieList.groupBy { it.movieListType }
        
        var categoryList = listOf<Category>()
        movieGroupList.forEach {
            if(it.key != null){
                val category = Category(it.key!!,it.value)
                categoryList = categoryList + category
            }
        }
        return@async categoryList
    }
}