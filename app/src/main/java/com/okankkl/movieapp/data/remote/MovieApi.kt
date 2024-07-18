package com.okankkl.movieapp.data.remote

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
            @Query("api_key") apiKey : String = Constants.API_KEY,
            @Query("page") page: Int
    ) : MovieResponseDto
    
}