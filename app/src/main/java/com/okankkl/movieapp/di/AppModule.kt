package com.okankkl.movieapp.di

import android.content.Context
import com.okankkl.movieapp.data.local.dataStore.AppPreference
import com.okankkl.movieapp.data.local.room.database.MovieDao
import com.okankkl.movieapp.data.local.room.database.MovieDatabase
import com.okankkl.movieapp.data.remote.MovieApi
import com.okankkl.movieapp.data.repository.MovieRepositoryImp
import com.okankkl.movieapp.data.repository.PreferenceRepositoryImp
import com.okankkl.movieapp.domain.repository.MovieRepository
import com.okankkl.movieapp.domain.repository.PreferenceRepository
import com.okankkl.movieapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule
{
    @Singleton
    @Provides
    fun provideRetrofit() : MovieApi {
        return Retrofit.Builder()
            .baseUrl(Constants.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }
    @Singleton
    @Provides
    fun provideMovieDao(@ApplicationContext context : Context) : MovieDao {
        return MovieDatabase
            .getDatabase(context)
            .dao()
    }
    
    @Singleton
    @Provides
    fun provideMovieRepository(movieApi: MovieApi,movieDao: MovieDao) : MovieRepository
    = MovieRepositoryImp(movieApi,movieDao)
    
    @Singleton
    @Provides
    fun provideAppPreference(@ApplicationContext context: Context) : AppPreference
     = AppPreference(context)
    
    @Singleton
    @Provides
    fun providePreferenceRepository(appPreference: AppPreference) : PreferenceRepository
        = PreferenceRepositoryImp(appPreference)
    
}