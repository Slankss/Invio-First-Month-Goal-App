package com.okankkl.movieapp.ui.home_screen;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0011H\u0016J\b\u0010\'\u001a\u00020\u0011H\u0016J\b\u0010(\u001a\u00020\u0011H\u0016J\u001a\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006+"}, d2 = {"Lcom/okankkl/movieapp/ui/home_screen/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/okankkl/movieapp/databinding/FragmentHomeBinding;", "binding", "getBinding", "()Lcom/okankkl/movieapp/databinding/FragmentHomeBinding;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "viewModel", "Lcom/okankkl/movieapp/ui/home_screen/HomeFragmentViewModel;", "getViewModel", "()Lcom/okankkl/movieapp/ui/home_screen/HomeFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "fillAdapter", "", "movieList", "", "Lcom/okankkl/movieapp/domain/model/Movie;", "adapter", "Lcom/okankkl/movieapp/ui/home_screen/MovieListAdapter;", "movieListType", "Lcom/okankkl/movieapp/util/MovieListType;", "navigateMovieDetail", "navController", "Landroidx/navigation/NavController;", "movieId", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onViewCreated", "view", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.okankkl.movieapp.databinding.FragmentHomeBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    
    public HomeFragment() {
        super();
    }
    
    private final com.okankkl.movieapp.databinding.FragmentHomeBinding getBinding() {
        return null;
    }
    
    private final com.okankkl.movieapp.ui.home_screen.HomeFragmentViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
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
    
    @java.lang.Override
    public void onResume() {
    }
    
    @java.lang.Override
    public void onPause() {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    private final void fillAdapter(java.util.List<com.okankkl.movieapp.domain.model.Movie> movieList, com.okankkl.movieapp.ui.home_screen.MovieListAdapter adapter, com.okankkl.movieapp.util.MovieListType movieListType) {
    }
    
    private final void navigateMovieDetail(androidx.navigation.NavController navController, int movieId) {
    }
}