package com.okankkl.movieapp.ui.home_screen

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.okankkl.movieapp.R
import com.okankkl.movieapp.domain.model.Movie

class MovieListAdapter(var onClick: (Int) -> Unit) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>()
{
    private var movieList = listOf<Movie>()
    
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val moviePosterImage : ImageView = itemView.findViewById(R.id.moviePosterImg)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListAdapter.ViewHolder
    {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_list_item,parent,false)
        return ViewHolder(itemView)
    }
    
    override fun onBindViewHolder(holder: MovieListAdapter.ViewHolder, position: Int)
    {
        val movie = movieList[position]
        Glide
            .with(holder.itemView)
            .load(movie.posterPath)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
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