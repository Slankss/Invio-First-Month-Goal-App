package com.okankkl.movieapp.ui.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.okankkl.movieapp.R
import com.okankkl.movieapp.data.model.Category
import com.okankkl.movieapp.util.LayoutType
import com.okankkl.movieapp.util.MovieListType

class CategoryAdapter(
        var onPosterClick: (Int) -> Unit,var onViewAllClick:(MovieListType) -> Unit
    ) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>()
{
    private var categoryList = listOf<Category>()
    
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val categoryRecyclerView : RecyclerView = itemView.findViewById(R.id.categoryRecyclerView)
        val categoryHeader : TextView = itemView.findViewById(R.id.categoryHeaderTxt)
        var viewAll : TextView = itemView.findViewById(R.id.viewallTxt)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val itemView = View.inflate(parent.context, R.layout.category_list_item,null)
        return ViewHolder(itemView)
    }
    
    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int)
    {
        val category = categoryList[position]
        holder.categoryHeader.text = holder.itemView.context.getText(category.listType.titleTextResourceId)
        
        // Create layout manager for each recycler view
        
        val layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL,false)
        val adapter = MovieListAdapter(
            layoutType = LayoutType.HorizontalLinear,
            onPosterClick = { movieId ->
               onPosterClick(movieId)
            }
        )
        holder.categoryRecyclerView.layoutManager = layoutManager
        holder.categoryRecyclerView.adapter = adapter
        adapter.setMovieList(category.movieList)
        
        holder.viewAll.setOnClickListener {
            onViewAllClick(category.listType)
        }
    }
    
    override fun getItemCount(): Int
    {
        return categoryList.size
    }
    
    fun setData(categories: List<Category>){
        categoryList = categories
    }
}