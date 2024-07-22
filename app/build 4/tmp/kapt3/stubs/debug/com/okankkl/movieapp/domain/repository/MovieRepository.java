package com.okankkl.movieapp.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\'\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0019H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/okankkl/movieapp/domain/repository/MovieRepository;", "", "addFavourite", "", "favouriteEntity", "Lcom/okankkl/movieapp/data/local/room/entity/FavouriteEntity;", "(Lcom/okankkl/movieapp/data/local/room/entity/FavouriteEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addMovieListToRoom", "movieList", "", "Lcom/okankkl/movieapp/domain/model/Movie;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearMovieListFromRoom", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFavourite", "movieId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovieDetail", "getMovieListFromApi", "movieListType", "Lcom/okankkl/movieapp/util/MovieListType;", "page", "(Lcom/okankkl/movieapp/util/MovieListType;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovieListFromRoom", "Lkotlinx/coroutines/flow/Flow;", "getSimilarMovies", "app_debug"})
public abstract interface MovieRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMovieListFromApi(@org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.util.MovieListType movieListType, int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.okankkl.movieapp.domain.model.Movie>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMovieListFromRoom(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.okankkl.movieapp.domain.model.Movie>>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addMovieListToRoom(@org.jetbrains.annotations.NotNull
    java.util.List<com.okankkl.movieapp.domain.model.Movie> movieList, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object clearMovieListFromRoom(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMovieDetail(int movieId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.okankkl.movieapp.domain.model.Movie> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getSimilarMovies(int movieId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.okankkl.movieapp.domain.model.Movie>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addFavourite(@org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.data.local.room.entity.FavouriteEntity favouriteEntity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteFavourite(int movieId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}