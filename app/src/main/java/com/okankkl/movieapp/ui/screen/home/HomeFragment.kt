package com.okankkl.movieapp.ui.screen.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
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
    private val binding get() = _binding
    private val viewModel: HomeFragmentViewModel by viewModels()
    
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        val view = binding?.root
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val state = viewModel.state
        
        val categoryAdapter = CategoryAdapter(
            onPosterClick = { movieId ->
                val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(movieId)
                findNavController().navigate(action)
            },
            onViewAllClick = { movieListType ->
                val action = HomeFragmentDirections.actionHomeFragmentToViewAllFragment(movieListType.routeName,
                    movieListType.titleTextResourceId)
                findNavController().navigate(action)
            }
        )
        binding?.categoryRecyclerView?.layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.VERTICAL,false)
        binding?.categoryRecyclerView?.adapter = categoryAdapter
        
        // observe state
        binding?.apply {
            lifecycleScope.launch {
                state.collect {
                    if(it.isLoading){
                        loadingProgressBar.visibility = View.VISIBLE
                        errorMessageTxt.visibility = View.GONE
                        errorMessageTxt.text = it.errorMessage
                    }
                    if(it.categoryList != null){
                        categoryAdapter.setData(it.categoryList)
                        categoryAdapter.notifyItemRangeChanged(0,it.categoryList.size)
                    
                        loadingProgressBar.visibility = View.GONE
                        errorMessageTxt.visibility = View.GONE
                    }
                    if(it.errorMessage.isNotEmpty()){
                        loadingProgressBar.visibility = View.GONE
                        errorMessageTxt.text = it.errorMessage
                        errorMessageTxt.visibility = View.VISIBLE
                    }
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
    
    override fun onDestroyView()
    {
        super.onDestroyView()
        _binding = null
    }
}