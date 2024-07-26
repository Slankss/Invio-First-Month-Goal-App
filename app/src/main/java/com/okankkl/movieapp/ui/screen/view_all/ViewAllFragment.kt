package com.okankkl.movieapp.ui.screen.view_all

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.okankkl.movieapp.databinding.FragmentViewAllBinding
import com.okankkl.movieapp.ui.adapter.MovieListAdapter
import com.okankkl.movieapp.ui.adapter.item_decoration.SpaceItemDecoration
import com.okankkl.movieapp.util.Constants.MOVIE_TYPE_ARG
import com.okankkl.movieapp.util.Constants.MOVIE_TYPE_STRING_ID_ARG
import com.okankkl.movieapp.util.LayoutType
import com.okankkl.movieapp.util.calculateSpanCount
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ViewAllFragment : Fragment()
{
    private var _binding : FragmentViewAllBinding? = null
    val binding get() = _binding
    private var movieTypeRouteName : String? = null
    private var movieTypeNameStringId: Int = 0
    private val viewModel: ViewAllFragmentViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // get arguments
        arguments?.let {
            movieTypeRouteName = it.getString(MOVIE_TYPE_ARG)
            movieTypeNameStringId = it.getInt(MOVIE_TYPE_STRING_ID_ARG)
        }
    }
    
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentViewAllBinding.inflate(inflater,container,false)
        val view = binding?.root
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val state = viewModel.state
        
        if(movieTypeRouteName != null){
            viewModel.loadMovies(movieTypeRouteName!!)
        }
        
        binding?.backBtn?.setOnClickListener {
            findNavController().popBackStack()
        }

        if(movieTypeNameStringId != 0){
            val text = getString(movieTypeNameStringId)
            binding?.movieTypeTxt?.text = text
        }
        
        val adapter = MovieListAdapter(
            layoutType = LayoutType.Grid,
            onPosterClick = { movieId ->
                val action = ViewAllFragmentDirections.actionViewAllFragmentToMovieDetailFragment(movieId)
                findNavController().navigate(action)
            },
            onLoad = {
                movieTypeRouteName?.let {
                    viewModel.loadMovies(it)
                }
            }
        )
        
        val spanCount = calculateSpanCount(requireContext(),LayoutType.Grid)
        val recyclerView = binding?.moviesRecyclerView
        val layoutManager = GridLayoutManager(requireContext(),spanCount)
        
        val spaceItemDecoration = SpaceItemDecoration(LayoutType.Grid)
        recyclerView?.addItemDecoration(spaceItemDecoration)
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = layoutManager
        
        lifecycleScope.launch {
            state.collect {
                if(it.movies != null) {
                    adapter.submitList(it.movies!!)
                }
            }
        }
    }
    
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}