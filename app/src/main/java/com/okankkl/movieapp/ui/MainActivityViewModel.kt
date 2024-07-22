package com.okankkl.movieapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okankkl.movieapp.domain.repository.PreferenceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val preferenceRepository: PreferenceRepository
): ViewModel()
{
    fun clearUpdateTime(){
        viewModelScope.launch {
            preferenceRepository.saveMovieUpdateTime("")
        }
    }
}