package com.okankkl.movieapp.data.local.room.entity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/okankkl/movieapp/data/local/room/entity/MovieEntity;", "", "id", "", "movieId", "backdropPath", "", "posterPath", "title", "movieListType", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackdropPath", "()Ljava/lang/String;", "getId", "()I", "getMovieId", "getMovieListType", "getPosterPath", "getTitle", "app_debug"})
@androidx.room.Entity(tableName = "movie")
public final class MovieEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final int id = 0;
    private final int movieId = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String backdropPath = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String posterPath = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String movieListType = null;
    
    public MovieEntity(int id, int movieId, @org.jetbrains.annotations.NotNull
    java.lang.String backdropPath, @org.jetbrains.annotations.NotNull
    java.lang.String posterPath, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    java.lang.String movieListType) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    public final int getMovieId() {
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
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMovieListType() {
        return null;
    }
}