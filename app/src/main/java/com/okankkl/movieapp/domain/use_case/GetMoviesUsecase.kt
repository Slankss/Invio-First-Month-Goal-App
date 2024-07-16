package com.okankkl.movieapp.domain.use_case

import com.okankkl.movieapp.data.remote.dto.MovieResponseDto
import com.okankkl.movieapp.domain.repository.MovieRepository
import com.okankkl.movieapp.util.MovieListType
import com.okankkl.movieapp.util.Resources
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GetMoviesUsecase @Inject constructor(val moviesRepository: MovieRepository)
{
    operator fun invoke(listType: String,page: Int) = flow{
        emit(Resources.Loading(true))
        try
        {
            val data = moviesRepository.getMovieList(listType,page)
            if(data.results.isEmpty()){
                emit(Resources.Error(message = "No data"))
            } else {
                emit(Resources.Success(data = data))
            }
        } catch(e : HttpException){
            emit(Resources.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}