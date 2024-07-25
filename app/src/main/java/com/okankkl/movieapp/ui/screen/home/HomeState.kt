package com.okankkl.movieapp.ui.screen.home

import com.okankkl.movieapp.data.model.Category

data class HomeState(
        val categoryList: List<Category>? = null,
        val isLoading: Boolean = false,
        val errorMessage: String = ""
)
