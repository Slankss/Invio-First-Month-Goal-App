package com.okankkl.movieapp.ui.splash_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okankkl.movieapp.data.repository.MovieRepositoryImp
import com.okankkl.movieapp.domain.repository.MovieRepository
import com.okankkl.movieapp.domain.use_case.GetMoviesUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashFragmentViewModel @Inject constructor(
    val getMoviesUsecase: GetMoviesUsecase,
    val movieRepository: MovieRepository
) : ViewModel()
{
    
    var currentPage = 1
    
    fun loadMovies(listType: String){
        viewModelScope.launch {
            Log.d("MOVIES","GIRDI")
            val data = movieRepository.getMovieList("popular",1)
            Log.d("MOVIES",data.results.toString())
        }
    }
    /*
    fun loadMovies(listType: String) = getMoviesUsecase(listType,currentPage).onEach { result ->
        when(result)
    }.launchIn(scope = viewModelScope)
    
     */
}