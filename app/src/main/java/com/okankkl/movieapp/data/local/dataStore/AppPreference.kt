package com.okankkl.movieapp.data.local.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.Preferences
import com.okankkl.movieapp.util.Constants.DATA_STORE_NAME
import com.okankkl.movieapp.util.Constants.UPDATE_TIME_PREFERENCES_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppPreference(private val context: Context)
{
    
    companion object {
        private val Context.dataStore: DataStore<Preferences>by preferencesDataStore(name = DATA_STORE_NAME)
        val MOVIE_UPDATE_TIME = stringPreferencesKey(UPDATE_TIME_PREFERENCES_KEY)
    }
    
    val getMovieUpdateTime : Flow<String?> = context.dataStore.data
        .map { preference ->
            preference[MOVIE_UPDATE_TIME]
        }
    
    suspend fun saveMovieUpdateTime(updateTime : String){
        context.dataStore.edit { preference ->
            preference[MOVIE_UPDATE_TIME] = updateTime
        }
    }
    
    
    
}