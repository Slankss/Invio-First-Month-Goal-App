package com.okankkl.movieapp.ui.screen.search
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.core.view.setPadding
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.okankkl.movieapp.R
import com.okankkl.movieapp.databinding.FragmentSearchBinding
import com.okankkl.movieapp.ui.adapter.MovieListAdapter
import com.okankkl.movieapp.util.LayoutType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment()
{
    private var _binding : FragmentSearchBinding? = null
    val binding get() = _binding!!
    private val viewModel : SearchFragmentViewModel by viewModels()
    private var scope = CoroutineScope(Dispatchers.Main)
    
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View
    {
        _binding = FragmentSearchBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        
        val state = viewModel.state
        var searchQuery  = ""
        var lastMovieId = 0
        val adapter = MovieListAdapter(
            layoutType = LayoutType.Grid,
            onClick = { movieId ->
                val action = SearchFragmentDirections.actionSearchFragmentToMovieDetailFragment(movieId)
                findNavController().navigate(action)
            },
            onLoad = { id ->
                viewModel.loadMovies(searchQuery)
                lastMovieId = id
            }
        )
        val recyclerView = binding.searchingMoviesRecyclerview
        val layoutManager = GridLayoutManager(requireContext(),3,GridLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        
        binding.movieSearchBtn.setOnClickListener{
            searchQuery = binding.movieSearchEditText.text.toString()
            if(searchQuery.isNotEmpty()){
                lastMovieId = 0
                viewModel.searchMovies(searchQuery)
                binding.movieSearchEditText.setText("")
            }
        }
        
        scope.launch {
            state.collect { movies ->
                adapter.setMovieList(movies)
                adapter.notifyDataSetChanged()
            }
        }
    }
    
    override fun onDestroy()
    {
        _binding = null
        super.onDestroy()
    }
}