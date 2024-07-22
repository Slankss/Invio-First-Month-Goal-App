package com.okankkl.movieapp.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0007J\b\u0010\u0011\u001a\u00020\fH\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/okankkl/movieapp/di/AppModule;", "", "()V", "provideAppPreference", "Lcom/okankkl/movieapp/data/local/dataStore/AppPreference;", "context", "Landroid/content/Context;", "provideMovieDao", "Lcom/okankkl/movieapp/data/local/room/database/MovieDao;", "provideMovieRepository", "Lcom/okankkl/movieapp/domain/repository/MovieRepository;", "movieApi", "Lcom/okankkl/movieapp/data/remote/MovieApi;", "movieDao", "providePreferenceRepository", "Lcom/okankkl/movieapp/domain/repository/PreferenceRepository;", "appPreference", "provideRetrofit", "app_debug"})
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
    public final com.okankkl.movieapp.data.local.room.database.MovieDao provideMovieDao(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @javax.inject.Singleton
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.okankkl.movieapp.domain.repository.MovieRepository provideMovieRepository(@org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.data.remote.MovieApi movieApi, @org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.data.local.room.database.MovieDao movieDao) {
        return null;
    }
    
    @javax.inject.Singleton
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.okankkl.movieapp.data.local.dataStore.AppPreference provideAppPreference(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @javax.inject.Singleton
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.okankkl.movieapp.domain.repository.PreferenceRepository providePreferenceRepository(@org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.data.local.dataStore.AppPreference appPreference) {
        return null;
    }
}