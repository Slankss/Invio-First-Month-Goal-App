package com.okankkl.movieapp.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ/\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u00072\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u00020\u000b2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/okankkl/movieapp/data/remote/MovieApi;", "", "getMovieDetail", "Lcom/okankkl/movieapp/data/remote/dto/MovieDetailDto;", "movieId", "", "apiKey", "", "appendToResponse", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovies", "Lcom/okankkl/movieapp/data/remote/dto/MovieResponseDto;", "listType", "page", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSimilarMovies", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface MovieApi {
    
    @retrofit2.http.GET(value = "/3/movie/{listType}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMovies(@retrofit2.http.Path(value = "listType")
    @org.jetbrains.annotations.NotNull
    java.lang.String listType, @retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull
    java.lang.String apiKey, @retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.okankkl.movieapp.data.remote.dto.MovieResponseDto> $completion);
    
    @retrofit2.http.GET(value = "/3/movie/{movieId}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMovieDetail(@retrofit2.http.Path(value = "movieId")
    int movieId, @retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull
    java.lang.String apiKey, @retrofit2.http.Query(value = "append_to_response")
    @org.jetbrains.annotations.NotNull
    java.lang.String appendToResponse, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.okankkl.movieapp.data.remote.dto.MovieDetailDto> $completion);
    
    @retrofit2.http.GET(value = "/3/movie/{movieId}/similar")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getSimilarMovies(@retrofit2.http.Path(value = "movieId")
    int movieId, @retrofit2.http.Query(value = "api_key")
    @org.jetbrains.annotations.NotNull
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.okankkl.movieapp.data.remote.dto.MovieResponseDto> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}