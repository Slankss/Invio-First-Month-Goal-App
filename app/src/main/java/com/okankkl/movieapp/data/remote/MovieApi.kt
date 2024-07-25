package com.okankkl.movieapp.data.remote

import com.okankkl.movieapp.data.remote.dto.MovieDetailDto
import com.okankkl.movieapp.data.remote.dto.MovieResponseDto
import com.okankkl.movieapp.util.Constants
import com.okankkl.movieapp.util.Constants.GET_MOVIES_ROUTE
import com.okankkl.movieapp.util.Constants.GET_MOVIE_DETAIL_ROUTE
import com.okankkl.movieapp.util.Constants.GET_SIMILAR_MOVIES_ROUTE
import com.okankkl.movieapp.util.Constants.SEARCH_MOVIES_ROUTE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi
{
    @GET(GET_MOVIES_ROUTE)
    suspend fun getMovies(
            @Path("listType") listType : String,
            @Query("page") page: Int,
            @Query("api_key") apiKey : String = Constants.API_KEY
    ) : MovieResponseDto
    
    @GET(GET_MOVIE_DETAIL_ROUTE)
    suspend fun getMovieDetail(
            @Path("movieId") movieId : Int,
            @Query("append_to_response") appendToResponse : String = "videos",
            @Query("api_key") apiKey : String = Constants.API_KEY
    ) : MovieDetailDto
    
    @GET(GET_SIMILAR_MOVIES_ROUTE)
    suspend fun getSimilarMovies(
            @Path("movieId")movieId: Int,
            @Query("api_key") apiKey: String = Constants.API_KEY
    ) : MovieResponseDto
    
    @GET(SEARCH_MOVIES_ROUTE)
    suspend fun searchMovie(
            @Query("query") searchQuery : String,
            @Query("page") page: Int,
            @Query("api_key") apiKey : String = Constants.API_KEY
    ) : MovieResponseDto
    
}