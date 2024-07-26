package com.okankkl.movieapp.data.data_source

import com.okankkl.movieapp.data.local.dataStore.AppPreference
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class DataStoreManager @Inject constructor(
    private val appPreference : AppPreference
) {
  
    suspend fun getMoviesUpdateTime() : String? {
        return appPreference.getMovieUpdateTime.first()
    }
    
    suspend fun saveUpdateTime(updateTime: String){
        appPreference.saveMovieUpdateTime(updateTime)
    }
    
}