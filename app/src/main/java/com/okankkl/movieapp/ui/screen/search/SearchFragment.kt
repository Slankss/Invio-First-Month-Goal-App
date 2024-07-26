package com.okankkl.movieapp.ui.screen.search
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.okankkl.movieapp.databinding.FragmentSearchBinding
import com.okankkl.movieapp.ui.adapter.MovieListAdapter
import com.okankkl.movieapp.ui.adapter.item_decoration.SpaceItemDecoration
import com.okankkl.movieapp.util.LayoutType
import com.okankkl.movieapp.util.calculateSpanCount
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private var _binding : FragmentSearchBinding? = null
    val binding get() = _binding
    private val viewModel : SearchFragmentViewModel by viewModels()
    
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater,container,false)
        val view = binding?.root
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val state = viewModel.state
        var searchQuery  = ""
        
        val adapter = MovieListAdapter(
            layoutType = LayoutType.Grid,
            onPosterClick = { movieId ->
                val action = SearchFragmentDirections.actionSearchFragmentToMovieDetailFragment(movieId)
                findNavController().navigate(action)
            },
            onLoad = {
                // if total page size is not end,load more movies about search query
                viewModel.loadMovies(searchQuery)
            }
        )
        val spanCount = calculateSpanCount(requireContext(),LayoutType.Grid)
        val recyclerView = binding?.searchingMoviesRecyclerview
        val layoutManager = GridLayoutManager(requireContext(),spanCount)
        
        val spaceItemDecoration = SpaceItemDecoration(LayoutType.Grid)
        recyclerView?.addItemDecoration(spaceItemDecoration)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter
        
        binding?.apply {
            movieSearchBtn.setOnClickListener {
                searchQuery = binding?.movieSearchEditText?.text.toString()
                if(searchQuery.isNotEmpty()) {
                    // User search new movie, so set current page to 1
                    viewModel.searchMovies(searchQuery)
                    movieSearchEditText.text.clear()
                }
            }
            
            lifecycleScope.launch {
                state.collect{
                    if(it.isLoading){
                        loadingProgressBar.visibility = View.VISIBLE
                        errorMessageTxt.visibility = View.GONE
                    }
                    if(it.movies != null){
                        loadingProgressBar.visibility = View.GONE
                        errorMessageTxt.visibility = View.GONE
                        adapter.submitList(it.movies!!)
                    }
                    if(it.errorMessage.isNotEmpty()){
                        loadingProgressBar.visibility = View.GONE
                        errorMessageTxt.visibility = View.VISIBLE
                        errorMessageTxt.text = it.errorMessage
                    }
                }
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}