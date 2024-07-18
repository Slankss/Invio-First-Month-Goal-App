package com.okankkl.movieapp.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0011\u0010\b\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0011H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/okankkl/movieapp/domain/repository/MovieRepository;", "", "addMovieListToRoom", "", "movieList", "", "Lcom/okankkl/movieapp/domain/model/Movie;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearMovieListFromRoom", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovieListFromApi", "movieListType", "Lcom/okankkl/movieapp/util/MovieListType;", "page", "", "(Lcom/okankkl/movieapp/util/MovieListType;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovieListFromRoom", "Lkotlinx/coroutines/flow/Flow;", "app_debug"})
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
}