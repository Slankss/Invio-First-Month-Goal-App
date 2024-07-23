package com.okankkl.movieapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.okankkl.movieapp.R
import com.okankkl.movieapp.data.local.room.entity.FavouriteEntity

class FavouritesAdapter(
        var onDeleteClick : (Int) -> Unit,
        var onCardClick:(Int) -> Unit
    ) : RecyclerView.Adapter<FavouritesAdapter.ViewHolder>()
{
    private var favouritesList = listOf<FavouriteEntity>()
    
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val moviePosterImage : ImageView = itemView.findViewById(R.id.moviePosterImg)
        val movieTitleTxt : TextView = itemView.findViewById(R.id.movieTitleTxt)
        val favouritesDeleteImg : ImageView = itemView.findViewById(R.id.favouritesDeleteImg)
        val favouritesCardView : CardView = itemView.findViewById(R.id.favouritesCardView)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouritesAdapter.ViewHolder
    {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.favourites_list_item,parent,false)
        return ViewHolder(itemView)
    }
    
    override fun onBindViewHolder(holder: FavouritesAdapter.ViewHolder, position: Int)
    {
        val favourite = favouritesList[position]
        holder.movieTitleTxt.text = favourite.title
        
        // Load poster image
        Glide
            .with(holder.itemView)
            .load(favourite.posterPath)
            .centerCrop()
            .placeholder(R.drawable.poster_placeholder)
            .into(holder.moviePosterImage)
        
        holder.favouritesDeleteImg.setOnClickListener {
            onDeleteClick(favourite.id)
        }
        holder.favouritesCardView.setOnClickListener {
            onCardClick(favourite.id)
        }
    }
    
    override fun getItemCount(): Int
    {
        return favouritesList.size
    }
    
    fun setData(favourites: List<FavouriteEntity>){
        favouritesList = favourites
    }
}