package com.okankkl.movieapp.data.repository

import com.okankkl.movieapp.data.local.dataStore.AppPreference
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class PreferenceRepositoryImp @Inject constructor(val appPreference: AppPreference) :
    PreferenceRepository
{
    
    override suspend fun getMovieUpdateTime(): String?
    {
        return appPreference.getMovieUpdateTime.first()
    }
    
    override suspend fun saveMovieUpdateTime(updateDate: String)
    {
        appPreference.saveMovieUpdateTime(updateDate)
    }
}