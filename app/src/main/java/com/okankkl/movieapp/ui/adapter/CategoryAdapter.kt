package com.okankkl.movieapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.okankkl.movieapp.data.model.Category
import com.okankkl.movieapp.databinding.CategoryListItemBinding
import com.okankkl.movieapp.ui.adapter.item_decoration.SpaceItemDecoration
import com.okankkl.movieapp.util.LayoutType
import com.okankkl.movieapp.util.MovieListType

class CategoryAdapter(
        var onPosterClick: (Int) -> Unit,var onViewAllClick:(MovieListType) -> Unit
    ) : ListAdapter<Category,CategoryAdapter.ViewHolder>(CategoryDiffCallBack())
{
    
    class ViewHolder(private val binding: CategoryListItemBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(
                category: Category,
                onPosterClick: (Int) -> Unit,
                onViewAllClick: (MovieListType) -> Unit
        ){
            with(binding){
                categoryHeaderTxt.text = itemView.context.getText(category.listType.titleTextResourceId)
                
                val layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL,false)
                val adapter = MovieListAdapter(
                    layoutType = LayoutType.HorizontalLinear,
                    onPosterClick = { movieId ->
                        onPosterClick(movieId)
                    }
                )
                val spaceItemDecoration = SpaceItemDecoration(LayoutType.HorizontalLinear)
                categoryRecyclerView.addItemDecoration(spaceItemDecoration)
                categoryRecyclerView.layoutManager = layoutManager
                categoryRecyclerView.adapter = adapter
                adapter.submitList(category.movieList)
                
                viewAllTxt.setOnClickListener {
                    onViewAllClick(category.listType)
                }
            }
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CategoryListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val category = getItem(position)
        holder.bind(category,onPosterClick,onViewAllClick)
    }
}

class CategoryDiffCallBack : DiffUtil.ItemCallback<Category>(){
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.listType == newItem.listType
    }
    
    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}