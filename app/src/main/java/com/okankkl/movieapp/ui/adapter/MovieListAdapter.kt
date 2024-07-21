package com.okankkl.movieapp.ui.adapter

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

class MovieListAdapter(var onClick: (Int) -> Unit) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>()
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
        
        if(position == 0){
            (holder.moviePosterCardView.layoutParams as MarginLayoutParams).marginStart = 25
        }
        
        val movieImage = when(movie.posterPath.isNotEmpty()){
            true -> movie.posterPath
            false -> movie.backdropPath
        }
        
        Glide
            .with(holder.itemView)
            .load(movieImage)
            .centerCrop()
            .placeholder(R.drawable.poster_placeholder)
            .into(holder.moviePosterImage)
        holder.moviePosterImage.setOnClickListener {
            onClick(movie.id)
        }
    }
    
    override fun getItemCount(): Int
    {
        return movieList.size
    }
    fun setMovieList(movies: List<Movie>){
        movieList = movies
    }
}