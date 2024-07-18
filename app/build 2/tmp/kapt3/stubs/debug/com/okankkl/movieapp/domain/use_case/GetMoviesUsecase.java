package com.okankkl.movieapp.domain.use_case;

import com.okankkl.movieapp.data.remote.dto.MovieResponseDto;
import com.okankkl.movieapp.domain.repository.MovieRepository;
import com.okankkl.movieapp.util.MovieListType;
import com.okankkl.movieapp.util.Resources;
import retrofit2.HttpException;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/okankkl/movieapp/domain/use_case/GetMoviesUsecase;", "", "moviesRepository", "Lcom/okankkl/movieapp/domain/repository/MovieRepository;", "(Lcom/okankkl/movieapp/domain/repository/MovieRepository;)V", "getMoviesRepository", "()Lcom/okankkl/movieapp/domain/repository/MovieRepository;", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/okankkl/movieapp/util/Resources;", "Lcom/okankkl/movieapp/data/remote/dto/MovieResponseDto;", "listType", "", "page", "", "app_debug"})
public final class GetMoviesUsecase {
    @org.jetbrains.annotations.NotNull
    private final com.okankkl.movieapp.domain.repository.MovieRepository moviesRepository = null;
    
    @javax.inject.Inject
    public GetMoviesUsecase(@org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.domain.repository.MovieRepository moviesRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.okankkl.movieapp.domain.repository.MovieRepository getMoviesRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.okankkl.movieapp.util.Resources<com.okankkl.movieapp.data.remote.dto.MovieResponseDto>> invoke(@org.jetbrains.annotations.NotNull
    java.lang.String listType, int page) {
        return null;
    }
}