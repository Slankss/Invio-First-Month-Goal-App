package com.okankkl.movieapp.data.repository

interface PreferenceRepository
{
    suspend fun getMovieUpdateTime(): String?
    
    suspend fun saveMovieUpdateTime(updateDate: String)
}