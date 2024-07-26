package com.okankkl.movieapp.util

import com.okankkl.movieapp.R

enum class LayoutType(
    val posterWidth: Int,
    var posterHeight: Int,
    var horizontalPadding: Int,
    var verticalPadding: Int
)
{
    Grid(
        posterWidth = R.dimen.grid_layout_poster_width,
        posterHeight = R.dimen.grid_layout_poster_height,
        horizontalPadding = R.dimen.grid_layout_horizontal_padding,
        verticalPadding = R.dimen.grid_layout_vertical_padding,
    ),
    HorizontalLinear(
        posterWidth = R.dimen.horizontal_layout_poster_width,
        posterHeight = R.dimen.horizontal_layout_poster_height,
        horizontalPadding = R.dimen.horizontal_layout_horizontal_padding,
        verticalPadding = R.dimen.horizontal_layout_vertical_padding,
    )
}