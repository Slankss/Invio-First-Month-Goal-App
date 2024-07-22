package com.okankkl.movieapp.domain.repository

import java.time.LocalDateTime

interface PreferenceRepository
{
    suspend fun getMovieUpdateTime() : String?
    
    suspend fun saveMovieUpdateTime(updateDate : String)
}