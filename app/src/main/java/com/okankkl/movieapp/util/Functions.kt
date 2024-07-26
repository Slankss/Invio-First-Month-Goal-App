package com.okankkl.movieapp.util

import android.content.Context

fun calculateSpanCount(context: Context, layoutType: LayoutType) : Int{
    val displayMetrics = context.resources.displayMetrics
    val screenWidthPx = displayMetrics.widthPixels
    val itemWidthPx = context.resources.getDimension(layoutType.posterWidth).toInt()
    val padding = context.resources.getDimension(layoutType.horizontalPadding).toInt()
    return maxOf(1,screenWidthPx / (itemWidthPx + padding))
}