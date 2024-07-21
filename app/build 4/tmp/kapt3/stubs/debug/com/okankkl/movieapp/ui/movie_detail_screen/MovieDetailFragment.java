package com.okankkl.movieapp.ui.movie_detail_screen;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010\'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006)"}, d2 = {"Lcom/okankkl/movieapp/ui/movie_detail_screen/MovieDetailFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/okankkl/movieapp/databinding/FragmentMovieDetailBinding;", "binding", "getBinding", "()Lcom/okankkl/movieapp/databinding/FragmentMovieDetailBinding;", "movieId", "", "getMovieId", "()Ljava/lang/Integer;", "setMovieId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "viewModel", "Lcom/okankkl/movieapp/ui/movie_detail_screen/MovieDetailFragmentViewModel;", "getViewModel", "()Lcom/okankkl/movieapp/ui/movie_detail_screen/MovieDetailFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "fillData", "", "movie", "Lcom/okankkl/movieapp/domain/model/Movie;", "getSimilarMoviesData", "loadMovieTrailer", "videoKey", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_debug"})
public final class MovieDetailFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.okankkl.movieapp.databinding.FragmentMovieDetailBinding _binding;
    @org.jetbrains.annotations.Nullable
    private java.lang.Integer movieId;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope scope = null;
    
    public MovieDetailFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.okankkl.movieapp.databinding.FragmentMovieDetailBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Integer getMovieId() {
        return null;
    }
    
    public final void setMovieId(@org.jetbrains.annotations.Nullable
    java.lang.Integer p0) {
    }
    
    private final com.okankkl.movieapp.ui.movie_detail_screen.MovieDetailFragmentViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getSimilarMoviesData() {
    }
    
    private final void fillData(com.okankkl.movieapp.domain.model.Movie movie) {
    }
    
    private final void loadMovieTrailer(java.lang.String videoKey) {
    }
}