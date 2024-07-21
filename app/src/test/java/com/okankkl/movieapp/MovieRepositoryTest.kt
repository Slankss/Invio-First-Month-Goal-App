package com.okankkl.movieapp

import com.okankkl.movieapp.repository.FakeMovieRepository
import org.junit.Test

class MovieRepositoryTest
{
    private val fakeMovieRepository = FakeMovieRepository()
    
    @Test
    fun getSimilarMoviesWithNotEmptyPosterPath() {
        //val similarMovies = fakeMovieRepository.getSimilarMovies(1)
    }
    
}