package com.okankkl.movieapp.data.repository;

import com.okankkl.movieapp.data.remote.MovieApi;
import com.okankkl.movieapp.data.remote.dto.MovieResponseDto;
import com.okankkl.movieapp.domain.repository.MovieRepository;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/okankkl/movieapp/data/repository/MovieRepositoryImp;", "Lcom/okankkl/movieapp/domain/repository/MovieRepository;", "movieApi", "Lcom/okankkl/movieapp/data/remote/MovieApi;", "(Lcom/okankkl/movieapp/data/remote/MovieApi;)V", "getMovieApi", "()Lcom/okankkl/movieapp/data/remote/MovieApi;", "getMovieList", "Lcom/okankkl/movieapp/data/remote/dto/MovieResponseDto;", "listType", "", "page", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MovieRepositoryImp implements com.okankkl.movieapp.domain.repository.MovieRepository {
    @org.jetbrains.annotations.NotNull
    private final com.okankkl.movieapp.data.remote.MovieApi movieApi = null;
    
    @javax.inject.Inject
    public MovieRepositoryImp(@org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.data.remote.MovieApi movieApi) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.okankkl.movieapp.data.remote.MovieApi getMovieApi() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getMovieList(@org.jetbrains.annotations.NotNull
    java.lang.String listType, int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.okankkl.movieapp.data.remote.dto.MovieResponseDto> $completion) {
        return null;
    }
}