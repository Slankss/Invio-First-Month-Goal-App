package com.okankkl.movieapp.domain.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u00002\u00020\u0001B_\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0012B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0002\u0010\u0015J\b\u00102\u001a\u0004\u0018\u00010\u0005R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\"R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b\'\u0010(R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u00063"}, d2 = {"Lcom/okankkl/movieapp/domain/model/Movie;", "", "id", "", "backdropPath", "", "posterPath", "title", "overview", "releaseDate", "voteAverage", "", "videos", "Lcom/okankkl/movieapp/data/remote/dto/Videos;", "genres", "", "Lcom/okankkl/movieapp/data/remote/dto/Genre;", "runtime", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLcom/okankkl/movieapp/data/remote/dto/Videos;Ljava/util/List;I)V", "movieListType", "Lcom/okankkl/movieapp/util/MovieListType;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/okankkl/movieapp/util/MovieListType;)V", "getBackdropPath", "()Ljava/lang/String;", "getGenres", "()Ljava/util/List;", "setGenres", "(Ljava/util/List;)V", "getId", "()I", "getMovieListType", "()Lcom/okankkl/movieapp/util/MovieListType;", "getOverview", "setOverview", "(Ljava/lang/String;)V", "getPosterPath", "getReleaseDate", "setReleaseDate", "getRuntime", "setRuntime", "(I)V", "getTitle", "getVideos", "()Lcom/okankkl/movieapp/data/remote/dto/Videos;", "setVideos", "(Lcom/okankkl/movieapp/data/remote/dto/Videos;)V", "getVoteAverage", "()D", "setVoteAverage", "(D)V", "getTrailerVideoKey", "app_debug"})
public final class Movie {
    private final int id = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String backdropPath = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String posterPath = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String title = null;
    @org.jetbrains.annotations.Nullable
    private final com.okankkl.movieapp.util.MovieListType movieListType = null;
    @org.jetbrains.annotations.NotNull
    private java.lang.String overview = "";
    @org.jetbrains.annotations.NotNull
    private java.lang.String releaseDate = "";
    private double voteAverage = 0.0;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.okankkl.movieapp.data.remote.dto.Genre> genres;
    private int runtime = 0;
    @org.jetbrains.annotations.Nullable
    private com.okankkl.movieapp.data.remote.dto.Videos videos;
    
    public Movie(int id, @org.jetbrains.annotations.NotNull
    java.lang.String backdropPath, @org.jetbrains.annotations.NotNull
    java.lang.String posterPath, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.Nullable
    com.okankkl.movieapp.util.MovieListType movieListType) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getBackdropPath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPosterPath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.okankkl.movieapp.util.MovieListType getMovieListType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getOverview() {
        return null;
    }
    
    public final void setOverview(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getReleaseDate() {
        return null;
    }
    
    public final void setReleaseDate(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final double getVoteAverage() {
        return 0.0;
    }
    
    public final void setVoteAverage(double p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.okankkl.movieapp.data.remote.dto.Genre> getGenres() {
        return null;
    }
    
    public final void setGenres(@org.jetbrains.annotations.NotNull
    java.util.List<com.okankkl.movieapp.data.remote.dto.Genre> p0) {
    }
    
    public final int getRuntime() {
        return 0;
    }
    
    public final void setRuntime(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.okankkl.movieapp.data.remote.dto.Videos getVideos() {
        return null;
    }
    
    public final void setVideos(@org.jetbrains.annotations.Nullable
    com.okankkl.movieapp.data.remote.dto.Videos p0) {
    }
    
    public Movie(int id, @org.jetbrains.annotations.NotNull
    java.lang.String backdropPath, @org.jetbrains.annotations.NotNull
    java.lang.String posterPath, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String overview, @org.jetbrains.annotations.NotNull
    java.lang.String releaseDate, double voteAverage, @org.jetbrains.annotations.Nullable
    com.okankkl.movieapp.data.remote.dto.Videos videos, @org.jetbrains.annotations.NotNull
    java.util.List<com.okankkl.movieapp.data.remote.dto.Genre> genres, int runtime) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTrailerVideoKey() {
        return null;
    }
}