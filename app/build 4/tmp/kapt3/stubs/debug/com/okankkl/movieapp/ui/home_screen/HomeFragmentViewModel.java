package com.okankkl.movieapp.ui.home_screen;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0012\u001a\u00020\u0013H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\u0013H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0011\u0010\u0016\u001a\u00020\u0013H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0011\u0010\u0017\u001a\u00020\u0013H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0006\u0010\u0018\u001a\u00020\u0013R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/okankkl/movieapp/ui/home_screen/HomeFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "movieRepository", "Lcom/okankkl/movieapp/domain/repository/MovieRepository;", "preferenceRepository", "Lcom/okankkl/movieapp/domain/repository/PreferenceRepository;", "(Lcom/okankkl/movieapp/domain/repository/MovieRepository;Lcom/okankkl/movieapp/domain/repository/PreferenceRepository;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/okankkl/movieapp/util/Resources;", "", "Lcom/okankkl/movieapp/domain/model/Movie;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "setState", "(Lkotlinx/coroutines/flow/StateFlow;)V", "addMoviesToRoom", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearMoviesFromRoom", "getMoviesFromApi", "getMoviesFromRoom", "loadMovies", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class HomeFragmentViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.okankkl.movieapp.domain.repository.MovieRepository movieRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.okankkl.movieapp.domain.repository.PreferenceRepository preferenceRepository = null;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.MutableStateFlow<com.okankkl.movieapp.util.Resources<java.util.List<com.okankkl.movieapp.domain.model.Movie>>> _state;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<? extends com.okankkl.movieapp.util.Resources<java.util.List<com.okankkl.movieapp.domain.model.Movie>>> state;
    
    @javax.inject.Inject
    public HomeFragmentViewModel(@org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.domain.repository.MovieRepository movieRepository, @org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.domain.repository.PreferenceRepository preferenceRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.okankkl.movieapp.util.Resources<java.util.List<com.okankkl.movieapp.domain.model.Movie>>> getState() {
        return null;
    }
    
    public final void setState(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<? extends com.okankkl.movieapp.util.Resources<java.util.List<com.okankkl.movieapp.domain.model.Movie>>> p0) {
    }
    
    public final void loadMovies() {
    }
    
    private final java.lang.Object getMoviesFromApi(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object clearMoviesFromRoom(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object addMoviesToRoom(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object getMoviesFromRoom(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}