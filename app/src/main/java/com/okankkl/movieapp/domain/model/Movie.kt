package com.okankkl.movieapp.domain.model

import android.util.Log
import com.okankkl.movieapp.data.remote.dto.Genre
import com.okankkl.movieapp.data.remote.dto.Video
import com.okankkl.movieapp.data.remote.dto.Videos
import com.okankkl.movieapp.util.Constants
import com.okankkl.movieapp.util.MovieListType
import java.util.Locale

class Movie(
    val id: Int,
    val backdropPath: String,
    val posterPath: String,
    val title: String,
    val movieListType: MovieListType? = null
){
    var overview : String = ""
    var releaseDate : String = ""
    var voteAverage : Double = 0.0
    var genres : List<Genre> = emptyList()
    var runtime : Int = 0
    var videos : Videos? = null
    var isMovieInFavourite = false
    
    constructor(id: Int, backdropPath: String, posterPath: String, title: String,
                overview: String, releaseDate: String, voteAverage : Double, videos: Videos?,
                genres: List<Genre>, runtime: Int,
        ) : this(id,backdropPath,posterPath,title){
            this.overview = overview
            this.releaseDate = releaseDate
            this.voteAverage = voteAverage
            this.genres = genres
            this.runtime = runtime
            this.videos = videos
    }
    
    fun getTrailerVideoKey() : String? {
         if(videos == null || videos!!.results.isEmpty())
             return null
        
         var trailer : Video? = null
         trailer = videos!!.results.find { it.type.lowercase(Locale.ROOT).contains("official") }
         
         if(trailer != null)
             return trailer.key
         return videos?.results?.last()?.key
    }
}
