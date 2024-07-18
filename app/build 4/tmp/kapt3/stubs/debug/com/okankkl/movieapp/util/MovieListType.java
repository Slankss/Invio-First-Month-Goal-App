package com.okankkl.movieapp.util;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u000b\f\r\u000eB\u0017\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0001\u0004\u000f\u0010\u0011\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/okankkl/movieapp/util/MovieListType;", "", "routeName", "", "titleTextId", "", "(Ljava/lang/String;I)V", "getRouteName", "()Ljava/lang/String;", "getTitleTextId", "()I", "NowPlaying", "Popular", "TopRated", "Upcoming", "Lcom/okankkl/movieapp/util/MovieListType$NowPlaying;", "Lcom/okankkl/movieapp/util/MovieListType$Popular;", "Lcom/okankkl/movieapp/util/MovieListType$TopRated;", "Lcom/okankkl/movieapp/util/MovieListType$Upcoming;", "app_debug"})
public abstract class MovieListType {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String routeName = null;
    private final int titleTextId = 0;
    
    private MovieListType(java.lang.String routeName, int titleTextId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRouteName() {
        return null;
    }
    
    public final int getTitleTextId() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/okankkl/movieapp/util/MovieListType$NowPlaying;", "Lcom/okankkl/movieapp/util/MovieListType;", "()V", "app_debug"})
    public static final class NowPlaying extends com.okankkl.movieapp.util.MovieListType {
        @org.jetbrains.annotations.NotNull
        public static final com.okankkl.movieapp.util.MovieListType.NowPlaying INSTANCE = null;
        
        private NowPlaying() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/okankkl/movieapp/util/MovieListType$Popular;", "Lcom/okankkl/movieapp/util/MovieListType;", "()V", "app_debug"})
    public static final class Popular extends com.okankkl.movieapp.util.MovieListType {
        @org.jetbrains.annotations.NotNull
        public static final com.okankkl.movieapp.util.MovieListType.Popular INSTANCE = null;
        
        private Popular() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/okankkl/movieapp/util/MovieListType$TopRated;", "Lcom/okankkl/movieapp/util/MovieListType;", "()V", "app_debug"})
    public static final class TopRated extends com.okankkl.movieapp.util.MovieListType {
        @org.jetbrains.annotations.NotNull
        public static final com.okankkl.movieapp.util.MovieListType.TopRated INSTANCE = null;
        
        private TopRated() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/okankkl/movieapp/util/MovieListType$Upcoming;", "Lcom/okankkl/movieapp/util/MovieListType;", "()V", "app_debug"})
    public static final class Upcoming extends com.okankkl.movieapp.util.MovieListType {
        @org.jetbrains.annotations.NotNull
        public static final com.okankkl.movieapp.util.MovieListType.Upcoming INSTANCE = null;
        
        private Upcoming() {
        }
    }
}