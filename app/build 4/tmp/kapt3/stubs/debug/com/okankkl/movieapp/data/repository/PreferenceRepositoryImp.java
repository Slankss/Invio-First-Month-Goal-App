package com.okankkl.movieapp.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/okankkl/movieapp/data/repository/PreferenceRepositoryImp;", "Lcom/okankkl/movieapp/domain/repository/PreferenceRepository;", "appPreference", "Lcom/okankkl/movieapp/data/local/dataStore/AppPreference;", "(Lcom/okankkl/movieapp/data/local/dataStore/AppPreference;)V", "getAppPreference", "()Lcom/okankkl/movieapp/data/local/dataStore/AppPreference;", "getMovieUpdateTime", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveMovieUpdateTime", "", "updateDate", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class PreferenceRepositoryImp implements com.okankkl.movieapp.domain.repository.PreferenceRepository {
    @org.jetbrains.annotations.NotNull
    private final com.okankkl.movieapp.data.local.dataStore.AppPreference appPreference = null;
    
    @javax.inject.Inject
    public PreferenceRepositoryImp(@org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.data.local.dataStore.AppPreference appPreference) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.okankkl.movieapp.data.local.dataStore.AppPreference getAppPreference() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getMovieUpdateTime(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object saveMovieUpdateTime(@org.jetbrains.annotations.NotNull
    java.lang.String updateDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}