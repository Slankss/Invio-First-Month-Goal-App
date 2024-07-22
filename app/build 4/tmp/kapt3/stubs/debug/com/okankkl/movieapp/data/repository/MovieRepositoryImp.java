package com.okankkl.movieapp.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u001f\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0011\u0010\u0011\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\'\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u001eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u001f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/okankkl/movieapp/data/repository/MovieRepositoryImp;", "Lcom/okankkl/movieapp/domain/repository/MovieRepository;", "movieApi", "Lcom/okankkl/movieapp/data/remote/MovieApi;", "movieDao", "Lcom/okankkl/movieapp/data/local/room/database/MovieDao;", "(Lcom/okankkl/movieapp/data/remote/MovieApi;Lcom/okankkl/movieapp/data/local/room/database/MovieDao;)V", "addFavourite", "", "favouriteEntity", "Lcom/okankkl/movieapp/data/local/room/entity/FavouriteEntity;", "(Lcom/okankkl/movieapp/data/local/room/entity/FavouriteEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addMovieListToRoom", "movieList", "", "Lcom/okankkl/movieapp/domain/model/Movie;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearMovieListFromRoom", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFavourite", "movieId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovieDetail", "getMovieListFromApi", "movieListType", "Lcom/okankkl/movieapp/util/MovieListType;", "page", "(Lcom/okankkl/movieapp/util/MovieListType;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovieListFromRoom", "Lkotlinx/coroutines/flow/Flow;", "getSimilarMovies", "app_debug"})
public final class MovieRepositoryImp implements com.okankkl.movieapp.domain.repository.MovieRepository {
    @org.jetbrains.annotations.NotNull
    private final com.okankkl.movieapp.data.remote.MovieApi movieApi = null;
    @org.jetbrains.annotations.NotNull
    private final com.okankkl.movieapp.data.local.room.database.MovieDao movieDao = null;
    
    @javax.inject.Inject
    public MovieRepositoryImp(@org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.data.remote.MovieApi movieApi, @org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.data.local.room.database.MovieDao movieDao) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getMovieListFromApi(@org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.util.MovieListType movieListType, int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.okankkl.movieapp.domain.model.Movie>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getMovieListFromRoom(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.okankkl.movieapp.domain.model.Movie>>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object addMovieListToRoom(@org.jetbrains.annotations.NotNull
    java.util.List<com.okankkl.movieapp.domain.model.Movie> movieList, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object clearMovieListFromRoom(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getMovieDetail(int movieId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.okankkl.movieapp.domain.model.Movie> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getSimilarMovies(int movieId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.okankkl.movieapp.domain.model.Movie>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object addFavourite(@org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.data.local.room.entity.FavouriteEntity favouriteEntity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object deleteFavourite(int movieId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}