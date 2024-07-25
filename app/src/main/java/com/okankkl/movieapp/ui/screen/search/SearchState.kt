package com.okankkl.movieapp.ui.screen.search

import com.okankkl.movieapp.domain.model.Movie

data class SearchState(
    var movies : List<Movie>? =  null,
    var isLoading : Boolean = false,
    var errorMessage : String = "",
    var currentPage : Int = 1,
    var totalPage : Int = 0,
    var pageSize : Int = 0
){
    fun isCurrentPageLessThenTotalPage() = currentPage < totalPage
}
