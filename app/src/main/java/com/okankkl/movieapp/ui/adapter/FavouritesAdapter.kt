package com.okankkl.movieapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.okankkl.movieapp.R
import com.okankkl.movieapp.data.extensions.getImagePath
import com.okankkl.movieapp.data.local.room.entity.FavouriteEntity
import com.okankkl.movieapp.databinding.FavouritesListItemBinding

class FavouritesAdapter(
        var onDeleteClick : (Int) -> Unit,
        var onCardClick:(Int) -> Unit
    ) : ListAdapter<FavouriteEntity,FavouritesAdapter.ViewHolder>(FavouriteDiffCallback())
{
    
    class ViewHolder(private val binding: FavouritesListItemBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(
                favourite: FavouriteEntity,
                onCardClick: (Int) -> Unit,
                onDeleteClick: (Int) -> Unit
                ) {
            with(binding){
                Glide
                    .with(root)
                    .load(favourite.getImagePath())
                    .centerCrop()
                    .placeholder(R.drawable.poster_placeholder)
                    .into(moviePosterImg)
                
                movieTitleTxt.text = favourite.title
                
                moviePosterImg.setOnClickListener {
                    onCardClick(favourite.id)
                }
                
                favouritesDeleteImg.setOnClickListener {
                    onDeleteClick(favourite.id)
                }
            }
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FavouritesListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val favourite = getItem(position)
        holder.bind(favourite, onCardClick,onDeleteClick)
    }
}

class FavouriteDiffCallback : DiffUtil.ItemCallback<FavouriteEntity>() {
    override fun areItemsTheSame(oldItem: FavouriteEntity, newItem: FavouriteEntity): Boolean {
        return oldItem.id == newItem.id
    }
    
    override fun areContentsTheSame(oldItem: FavouriteEntity, newItem: FavouriteEntity): Boolean {
        return oldItem == newItem
    }
}