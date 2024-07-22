package com.okankkl.movieapp.ui.movie_detail_screen;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\r\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\n0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010\u00a8\u0006\u001e"}, d2 = {"Lcom/okankkl/movieapp/ui/movie_detail_screen/MovieDetailFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "movieRepository", "Lcom/okankkl/movieapp/domain/repository/MovieRepository;", "(Lcom/okankkl/movieapp/domain/repository/MovieRepository;)V", "_similarMovies", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/okankkl/movieapp/domain/model/Movie;", "_state", "Lcom/okankkl/movieapp/util/Resources;", "similarMovies", "Lkotlinx/coroutines/flow/StateFlow;", "getSimilarMovies", "()Lkotlinx/coroutines/flow/StateFlow;", "setSimilarMovies", "(Lkotlinx/coroutines/flow/StateFlow;)V", "state", "getState", "setState", "addFavorite", "", "movieId", "", "title", "", "posterPath", "backdropPath", "deleteFavourite", "getMovieDetail", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class MovieDetailFragmentViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.okankkl.movieapp.domain.repository.MovieRepository movieRepository = null;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.MutableStateFlow<com.okankkl.movieapp.util.Resources<com.okankkl.movieapp.domain.model.Movie>> _state;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<? extends com.okankkl.movieapp.util.Resources<com.okankkl.movieapp.domain.model.Movie>> state;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.okankkl.movieapp.domain.model.Movie>> _similarMovies;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.okankkl.movieapp.domain.model.Movie>> similarMovies;
    
    @javax.inject.Inject
    public MovieDetailFragmentViewModel(@org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.domain.repository.MovieRepository movieRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.okankkl.movieapp.util.Resources<com.okankkl.movieapp.domain.model.Movie>> getState() {
        return null;
    }
    
    public final void setState(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<? extends com.okankkl.movieapp.util.Resources<com.okankkl.movieapp.domain.model.Movie>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.okankkl.movieapp.domain.model.Movie>> getSimilarMovies() {
        return null;
    }
    
    public final void setSimilarMovies(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.okankkl.movieapp.domain.model.Movie>> p0) {
    }
    
    public final void getMovieDetail(int movieId) {
    }
    
    public final void getSimilarMovies(int movieId) {
    }
    
    public final void addFavorite(int movieId, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String posterPath, @org.jetbrains.annotations.NotNull
    java.lang.String backdropPath) {
    }
    
    public final void deleteFavourite(int movieId) {
    }
}