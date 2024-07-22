package com.okankkl.movieapp.ui.screen.viewall

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgument
import androidx.recyclerview.widget.GridLayoutManager
import com.okankkl.movieapp.R
import com.okankkl.movieapp.databinding.FragmentHomeBinding
import com.okankkl.movieapp.databinding.FragmentViewAllBinding
import com.okankkl.movieapp.ui.adapter.MovieListAdapter
import com.okankkl.movieapp.util.Constants
import com.okankkl.movieapp.util.LayoutType
import com.okankkl.movieapp.util.MovieListType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ViewAllFragment : Fragment()
{
    private var _binding : FragmentViewAllBinding? = null
    val binding get() = _binding!!
    var movieTypeRouteName : String? = null
    var movieTypeNameStringId: Int = 0
    private val viewModel: ViewAllFragmentViewModel by viewModels()
    private val scope = CoroutineScope(Dispatchers.Main)
    
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View
    {
        _binding= FragmentViewAllBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        
        val state = viewModel.state
        
        arguments?.let {
            movieTypeRouteName = it.getString(Constants.VIEWAL_MOVIE_LIST_TYPE_ROUTE_NAME_ARG)
            movieTypeNameStringId = it.getInt(Constants.VIEWALL_MOVIE_LIST_TYPE_NAME_STRING_ID_ARG)
        }
        
        if(movieTypeNameStringId != 0){
            binding.movieTypeTxt.setText(movieTypeNameStringId)
        }
        
        if(movieTypeRouteName != null){
            viewModel.loadMovies(movieTypeRouteName!!)
        }
        
        var lastMovieId = 0
        val adapter = MovieListAdapter(
            layoutType = LayoutType.Grid,
            onClick = {
            
            },
            onLoad = { id ->
                movieTypeRouteName?.let {
                    viewModel.loadMovies(it)
                    lastMovieId = id
                }
            }
        )
        val recyclerView = binding.moviesRecyclerView
        val layoutManager = GridLayoutManager(requireContext(),3,GridLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
        
        scope.launch {
            state.collect{
                val data = it.data
                if(data != null){
                    adapter.setMovieList(data)
                    adapter.notifyItemRangeChanged(lastMovieId,data.size)
                }
            }
        }
        
        
    }
    
    override fun onDestroy()
    {
        _binding = null
        super.onDestroy()
    }
}