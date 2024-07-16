package com.okankkl.movieapp.di

import com.okankkl.movieapp.data.remote.MovieApi
import com.okankkl.movieapp.data.repository.MovieRepositoryImp
import com.okankkl.movieapp.domain.repository.MovieRepository
import com.okankkl.movieapp.domain.use_case.GetMoviesUsecase
import com.okankkl.movieapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideMovieRepository(movieApi: MovieApi) : MovieRepository
    = MovieRepositoryImp(movieApi)
    
    @Singleton
    @Provides
    fun provideGetMoviesUsecase(movieRepository: MovieRepository) = GetMoviesUsecase(movieRepository)

}