package com.okankkl.movieapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.okankkl.movieapp.R
import com.okankkl.movieapp.data.extensions.getImagePath
import com.okankkl.movieapp.data.model.Movie
import com.okankkl.movieapp.databinding.MovieListItemBinding
import com.okankkl.movieapp.util.LayoutType

class MovieListAdapter(
        var layoutType: LayoutType = LayoutType.HorizontalLinear,
        var onPosterClick: (Int) -> Unit,
        var onLoad: (() -> Unit)? = null
        )
    : ListAdapter<Movie,MovieListAdapter.ViewHolder>(MovieDiffCallback())
{
    class ViewHolder(private val binding: MovieListItemBinding)
        : RecyclerView.ViewHolder(binding.root){
       fun bind(
               layoutType: LayoutType,
               movie : Movie,
               onPosterClick: (Int) -> Unit
       ){
           with(binding){
               
               // Horizontal Linear Layout size
               val posterWidth = itemView.resources.getDimensionPixelSize(layoutType.posterWidth)
               val posterHeight = itemView.resources.getDimensionPixelSize(layoutType.posterHeight)
               
               moviePosterCardView.layoutParams.width = posterWidth
               moviePosterCardView.layoutParams.height = posterHeight
               // Load poster image
               Glide
                   .with(root)
                   .load(movie.getImagePath())
                   .centerCrop()
                   .placeholder(R.drawable.poster_placeholder)
                   .into(moviePosterImg)
               
               moviePosterImg.setOnClickListener {
                   onPosterClick(movie.id!!)
               }
           }
       }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MovieListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        //changeMarginAttributes(holder,position)
        
        holder.bind(layoutType,movie,onPosterClick)
        
        // if use reach the last item load movies (just viewAll page)
        if(position == itemCount -1){
            onLoad?.let { it()}
        }
    }
}

class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }
    
    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
    
}