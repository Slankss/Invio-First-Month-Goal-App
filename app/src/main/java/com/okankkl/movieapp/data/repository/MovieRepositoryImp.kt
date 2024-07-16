package com.okankkl.movieapp.data.repository

import com.okankkl.movieapp.data.remote.MovieApi
import com.okankkl.movieapp.data.remote.dto.MovieResponseDto
import com.okankkl.movieapp.domain.repository.MovieRepository
import javax.inject.Inject
import javax.inject.Singleton

class MovieRepositoryImp @Inject constructor(val movieApi: MovieApi)
    : MovieRepository
{
    override suspend fun getMovieList(listType: String, page: Int): MovieResponseDto
    {
        return movieApi.getMovies(listType,page = page)
    }
}