package com.okankkl.movieapp.di;

import com.okankkl.movieapp.data.remote.MovieApi;
import com.okankkl.movieapp.domain.repository.MovieRepository;
import com.okankkl.movieapp.domain.use_case.GetMoviesUsecase;
import com.okankkl.movieapp.util.Constants;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.scopes.ActivityScoped;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import javax.inject.Singleton;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/okankkl/movieapp/di/AppModule;", "", "()V", "provideGetMoviesUsecase", "Lcom/okankkl/movieapp/domain/use_case/GetMoviesUsecase;", "movieRepository", "Lcom/okankkl/movieapp/domain/repository/MovieRepository;", "provideRetrofit", "Lcom/okankkl/movieapp/data/remote/MovieApi;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    
    public AppModule() {
        super();
    }
    
    @javax.inject.Singleton
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.okankkl.movieapp.data.remote.MovieApi provideRetrofit() {
        return null;
    }
    
    @javax.inject.Singleton
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.okankkl.movieapp.domain.use_case.GetMoviesUsecase provideGetMoviesUsecase(@org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.domain.repository.MovieRepository movieRepository) {
        return null;
    }
}