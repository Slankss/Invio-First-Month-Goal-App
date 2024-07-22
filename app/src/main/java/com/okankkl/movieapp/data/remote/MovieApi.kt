package com.okankkl.movieapp.data.remote

import com.okankkl.movieapp.data.remote.dto.MovieDetailDto
import com.okankkl.movieapp.data.remote.dto.MovieResponseDto
import com.okankkl.movieapp.util.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi
{
    @GET("/3/movie/{listType}")
    suspend fun getMovies(
            @Path("listType") listType : String,
            @Query("page") page: Int,
            @Query("api_key") apiKey : String = Constants.API_KEY
    ) : MovieResponseDto
    
    @GET("/3/movie/{movieId}")
    suspend fun getMovieDetail(
            @Path("movieId") movieId : Int,
            @Query("append_to_response") appendToResponse : String = "videos",
            @Query("api_key") apiKey : String = Constants.API_KEY
    ) : MovieDetailDto
    
    @GET("/3/movie/{movieId}/similar")
    suspend fun getSimilarMovies(
            @Path("movieId")movieId: Int,
            @Query("api_key") apiKey: String = Constants.API_KEY
    ) : MovieResponseDto
    
    @GET("/3/search/movie")
    suspend fun searchMovie(
            @Query("query") searchQuery : String,
            @Query("page") page: Int,
            @Query("api_key") apiKey : String = Constants.API_KEY
    ) : MovieResponseDto
    
}