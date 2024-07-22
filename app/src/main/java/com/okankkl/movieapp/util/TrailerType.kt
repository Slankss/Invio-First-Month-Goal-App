package com.okankkl.movieapp.util

enum class TrailerType(
    typeName: String = "Trailer",
    priority: Int,
    name: String
)
{
    OfficailTrailer(
        name = "Officail Trailer",
        priority = 1
    )
}