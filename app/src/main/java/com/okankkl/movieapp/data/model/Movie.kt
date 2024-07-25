package com.okankkl.movieapp.data.model

import com.okankkl.movieapp.data.remote.dto.Genre
import com.okankkl.movieapp.data.remote.dto.Video
import com.okankkl.movieapp.data.remote.dto.Videos
import com.okankkl.movieapp.util.MovieListType
import java.util.Locale

data class Movie(
    val id: Int?,
    val backdropPath: String,
    val posterPath: String,
    val title: String,
    val movieListType: MovieListType? = null,
    var overview : String = "",
    var releaseDate : String = "",
    var voteAverage : Double = 0.0,
    var genres : List<Genre>? = null,
    var runtime : Int = 0,
    var videos : Videos? = null,
    var isMovieInFavourite : Boolean = false,
){
    fun getTrailerVideoKey() : String? {
        if(videos!!.results != null){
            if(videos == null || videos!!.results!!.isEmpty())
                return null
            val trailer : Video? = videos!!.results!!
                .find { it.type?.lowercase(Locale.ROOT)?.contains("official") == true }
            
            if(trailer != null)
                return trailer.key
            return videos?.results?.last()?.key
        }
        return null
    }
}
