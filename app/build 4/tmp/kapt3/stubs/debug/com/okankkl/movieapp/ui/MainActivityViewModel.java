package com.okankkl.movieapp.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/okankkl/movieapp/ui/MainActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "preferenceRepository", "Lcom/okankkl/movieapp/domain/repository/PreferenceRepository;", "(Lcom/okankkl/movieapp/domain/repository/PreferenceRepository;)V", "clearUpdateTime", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class MainActivityViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.okankkl.movieapp.domain.repository.PreferenceRepository preferenceRepository = null;
    
    @javax.inject.Inject
    public MainActivityViewModel(@org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.domain.repository.PreferenceRepository preferenceRepository) {
        super();
    }
    
    public final void clearUpdateTime() {
    }
}