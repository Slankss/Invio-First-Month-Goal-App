package com.okankkl.movieapp.ui.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.okankkl.movieapp.databinding.FragmentHomeBinding
import com.okankkl.movieapp.ui.adapter.CategoryAdapter
import dagger.hilt.android.AndroidEntryPoint
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
        viewModel.getMovies()
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
                        categoryAdapter.submitList(it.categoryList)
                    
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
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}