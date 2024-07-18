package com.okankkl.movieapp.data.repository

import android.content.Context
import com.okankkl.movieapp.data.local.dataStore.AppPreference
import com.okankkl.movieapp.domain.repository.PreferenceRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import java.time.LocalDateTime
import javax.inject.Inject

class PreferenceRepositoryImp @Inject constructor(val appPreference: AppPreference) : PreferenceRepository
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