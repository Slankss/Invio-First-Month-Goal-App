package com.okankkl.movieapp.ui.screen.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.okankkl.movieapp.databinding.FragmentHomeBinding
import com.okankkl.movieapp.domain.model.Category
import com.okankkl.movieapp.domain.model.Movie
import com.okankkl.movieapp.ui.adapter.CategoryAdapter
import com.okankkl.movieapp.ui.adapter.MovieListAdapter
import com.okankkl.movieapp.util.MovieListType
import com.okankkl.movieapp.util.Result
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment()
{
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val scope = CoroutineScope(Dispatchers.Main)
    private val viewModel: HomeFragmentViewModel by viewModels()
    
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater)
        val view = binding.root
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val state = viewModel.state
        
        val navController = findNavController()
        val categoryAdapter = CategoryAdapter(
            onPosterClick = { movieId ->
                val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(movieId)
                navController.navigate(action)
            },
            onViewAllClick = { movieListType ->
                val action = HomeFragmentDirections.actionHomeFragmentToViewAllFragment(movieListType.routeName,
                    movieListType.titleTextResourceId)
                navController.navigate(action)
            }
        )
        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.VERTICAL,false)
        binding.categoryRecyclerView.adapter = categoryAdapter
        
        // observe state
        scope.launch(Dispatchers.Main) {
            state.collect { movieListState ->
                changeViewVisibility(categoryAdapter,movieListState)
            }
        }
    }
    
    private fun changeViewVisibility(categoryAdapter: CategoryAdapter,result: Result<List<Category>>){
        binding.apply {
            when(result){
                is Result.Success -> {
                    categoryAdapter.setData(result.data)
                    categoryAdapter.notifyItemRangeChanged(0,result.data.size)
                    
                    binding.loadingProgressBar.visibility = View.GONE
                    binding.errorMessageTxt.visibility = View.GONE
                }
                is Result.Initial -> {
                    if(result.isLoading){
                        binding.loadingProgressBar.visibility = View.VISIBLE
                        binding.errorMessageTxt.visibility = View.GONE
                    }
                }
                is Result.Error -> {
                    loadingProgressBar.visibility = View.GONE
                    errorMessageTxt.text = result.message
                    errorMessageTxt.visibility = View.VISIBLE
                }
            }
        }
    }
    
    override fun onResume() {
        super.onResume()
        val viewModel: HomeFragmentViewModel by viewModels()
        viewModel.loadMovies()
    }
    
    override fun onPause() {
        super.onPause()
        viewModel.clearState()
    }
    
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}