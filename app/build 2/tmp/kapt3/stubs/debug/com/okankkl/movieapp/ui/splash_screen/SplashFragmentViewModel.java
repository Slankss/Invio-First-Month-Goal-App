package com.okankkl.movieapp.ui.splash_screen;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.okankkl.movieapp.data.repository.MovieRepositoryImp;
import com.okankkl.movieapp.domain.repository.MovieRepository;
import com.okankkl.movieapp.domain.use_case.GetMoviesUsecase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/okankkl/movieapp/ui/splash_screen/SplashFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "getMoviesUsecase", "Lcom/okankkl/movieapp/domain/use_case/GetMoviesUsecase;", "movieRepository", "Lcom/okankkl/movieapp/data/repository/MovieRepositoryImp;", "(Lcom/okankkl/movieapp/domain/use_case/GetMoviesUsecase;Lcom/okankkl/movieapp/data/repository/MovieRepositoryImp;)V", "currentPage", "", "getCurrentPage", "()I", "setCurrentPage", "(I)V", "getGetMoviesUsecase", "()Lcom/okankkl/movieapp/domain/use_case/GetMoviesUsecase;", "getMovieRepository", "()Lcom/okankkl/movieapp/data/repository/MovieRepositoryImp;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SplashFragmentViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.okankkl.movieapp.domain.use_case.GetMoviesUsecase getMoviesUsecase = null;
    @org.jetbrains.annotations.NotNull
    private final com.okankkl.movieapp.data.repository.MovieRepositoryImp movieRepository = null;
    private int currentPage = 1;
    
    @javax.inject.Inject
    public SplashFragmentViewModel(@org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.domain.use_case.GetMoviesUsecase getMoviesUsecase, @org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.data.repository.MovieRepositoryImp movieRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.okankkl.movieapp.domain.use_case.GetMoviesUsecase getGetMoviesUsecase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.okankkl.movieapp.data.repository.MovieRepositoryImp getMovieRepository() {
        return null;
    }
    
    public final int getCurrentPage() {
        return 0;
    }
    
    public final void setCurrentPage(int p0) {
    }
}