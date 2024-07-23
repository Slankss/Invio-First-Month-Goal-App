package com.okankkl.movieapp.ui.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.okankkl.movieapp.R
import com.okankkl.movieapp.domain.model.Movie
import com.okankkl.movieapp.util.LayoutType

class MovieListAdapter(
        var layoutType: LayoutType = LayoutType.HorizontalLinear,
        var onPosterClick: (Int) -> Unit,
        var onLoad: ((Int) -> Unit)? = null
        )
    : RecyclerView.Adapter<MovieListAdapter.ViewHolder>()
{
    private var movieList = listOf<Movie>()
    
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val moviePosterImage : ImageView = itemView.findViewById(R.id.moviePosterImg)
        val moviePosterCardView : CardView = itemView.findViewById(R.id.moviePosterCardView)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_list_item,parent,false)
        return ViewHolder(itemView)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val movie = movieList[position]
     
        changeMarginAttributes(holder,position)
        
        // if poster path is empty, use backdrop path
        val movieImage = when(movie.posterPath.isNotEmpty()){
            true -> movie.posterPath
            false -> movie.backdropPath
        }
        // Load poster image
        Glide
            .with(holder.itemView)
            .load(movieImage)
            .centerCrop()
            .placeholder(R.drawable.poster_placeholder)
            .into(holder.moviePosterImage)
        
        holder.moviePosterImage.setOnClickListener {
            onPosterClick(movie.id)
        }
        
        // if use reach the last item load movies (just viewAll page)
        if(position == movieList.size -1){
            onLoad?.let { it(position) }
        }
    }
    
    override fun getItemCount(): Int
    {
        return movieList.size
    }
    fun setMovieList(movies: List<Movie>){
        movieList = movies
    }
    
    private fun changeMarginAttributes(holder: ViewHolder, position: Int){
        // get moviePosterCardView margin params to change items attributes
        val moviePosterParams = holder.moviePosterCardView.layoutParams as MarginLayoutParams
        
        // change items attributes for different layout types
        if(layoutType == LayoutType.Grid){
            moviePosterParams.marginStart = dpToPx(5)
            moviePosterParams.topMargin = dpToPx(5)
            moviePosterParams.bottomMargin = dpToPx(5)
            moviePosterParams.marginEnd= dpToPx(5)
        } else {
            when(position){
                0 -> moviePosterParams.marginStart= dpToPx(20)
                movieList.size -1 -> moviePosterParams.marginEnd= dpToPx(20)
                else -> moviePosterParams.marginStart= dpToPx(10)
            }
        }
    }
    
    private fun dpToPx(dp: Int) : Int {
        val density = Resources.getSystem().displayMetrics.density
        return (dp * density).toInt()
    }
}