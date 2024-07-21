package com.okankkl.movieapp.util

sealed class Resources<T>(){
    data class Success<T>(val data : T) : Resources<T>()
    data class Error<T>(val message : String) : Resources<T>()
    data class Loading<T>(val isLoading : Boolean = false) : Resources<T>()
}
