package com.okankkl.movieapp.domain.repository;

import com.okankkl.movieapp.data.remote.MovieApi;
import com.okankkl.movieapp.data.remote.dto.MovieResponseDto;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/okankkl/movieapp/domain/repository/MovieRepository;", "", "getMovieList", "Lcom/okankkl/movieapp/data/remote/dto/MovieResponseDto;", "listType", "", "page", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface MovieRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMovieList(@org.jetbrains.annotations.NotNull
    java.lang.String listType, int page, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.okankkl.movieapp.data.remote.dto.MovieResponseDto> $completion);
}