package com.okankkl.movieapp.data.local.room.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0013H\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/okankkl/movieapp/data/local/room/database/MovieDao;", "", "addFavourite", "", "favouriteEntity", "Lcom/okankkl/movieapp/data/local/room/entity/FavouriteEntity;", "(Lcom/okankkl/movieapp/data/local/room/entity/FavouriteEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addMovies", "movieList", "", "Lcom/okankkl/movieapp/data/local/room/entity/MovieEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearMovies", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFavourite", "movieId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovies", "Lkotlinx/coroutines/flow/Flow;", "app_debug"})
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
    
    @androidx.room.Insert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object addFavourite(@org.jetbrains.annotations.NotNull
    com.okankkl.movieapp.data.local.room.entity.FavouriteEntity favouriteEntity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM favourite WHERE id = :movieId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteFavourite(int movieId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}