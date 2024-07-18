package com.okankkl.movieapp.data.local.room.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0011\u0010\b\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000bH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/okankkl/movieapp/data/local/room/database/MovieDao;", "", "addMovies", "", "movieList", "", "Lcom/okankkl/movieapp/data/local/room/entity/MovieEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearMovies", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovies", "Lkotlinx/coroutines/flow/Flow;", "app_debug"})
@androidx.room.Dao
public abstract interface MovieDao {
    
    @androidx.room.Query(value = "SELECT * FROM movie")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.okankkl.movieapp.data.local.room.entity.MovieEntity>> getMovies();
    
    @androidx.room.Upsert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addMovies(@org.jetbrains.annotations.NotNull
    java.util.List<com.okankkl.movieapp.data.local.room.entity.MovieEntity> movieList, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM movie")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object clearMovies(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}