package com.okankkl.movieapp.domain.repository

import com.okankkl.movieapp.data.remote.MovieApi
import com.okankkl.movieapp.data.remote.dto.MovieResponseDto
import javax.inject.Inject

interface MovieRepository
{
    suspend fun getMovieList(listType : String, page : Int) : MovieResponseDto
}