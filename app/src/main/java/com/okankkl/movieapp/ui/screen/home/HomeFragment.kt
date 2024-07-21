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
import com.okankkl.movieapp.domain.model.Movie
import com.okankkl.movieapp.ui.adapter.MovieListAdapter
import com.okankkl.movieapp.util.MovieListType
import com.okankkl.movieapp.util.Resources
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment()
{
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    private val scope = CoroutineScope(Dispatchers.Main)
    private val viewModel: HomeFragmentViewModel by viewModels()
    
    
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View?
    {
        _binding = FragmentHomeBinding.inflate(inflater)
        val view = binding?.root
        
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        val state = viewModel.state
        
        val navController = findNavController()
        val popularMoviesAdapter = MovieListAdapter{ movieId ->
            navigateMovieDetail(navController,movieId)
        }
        val nowPlayingMoviesAdapter = MovieListAdapter{ movieId ->
            navigateMovieDetail(navController,movieId)
        }
        val upComingMoviesAdapter = MovieListAdapter{ movieId ->
            navigateMovieDetail(navController,movieId)
        }
        val topRatedMoviesAdapter = MovieListAdapter{ movieId ->
            navigateMovieDetail(navController,movieId)
        }
        
        binding?.apply {
            popularMoviesRecyclerView.layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.HORIZONTAL,false)
            nowPlayingMoviesRecyclerView.layoutManager = LinearLayoutManager(view.context,LinearLayoutManager.HORIZONTAL,false)
            upComingMoviesRecyclerView.layoutManager =  LinearLayoutManager(view.context,LinearLayoutManager.HORIZONTAL,false)
            topRatedMoviesRecyclerView.layoutManager =  LinearLayoutManager(view.context,LinearLayoutManager.HORIZONTAL,false)
            
            popularMoviesRecyclerView.adapter = popularMoviesAdapter
            nowPlayingMoviesRecyclerView.adapter = nowPlayingMoviesAdapter
            upComingMoviesRecyclerView.adapter = upComingMoviesAdapter
            topRatedMoviesRecyclerView.adapter = topRatedMoviesAdapter
            
            viewAllPopularMoviesTxt.setOnClickListener {
            
            }
            viewAllNowPlayingMoviesTxt.setOnClickListener {
            
            }
            viewAllUpComingMoviesTxt.setOnClickListener {
            }
            viewAllTopRatedMoviesTxt.setOnClickListener {
            
            }
        }
        
        scope.launch(Dispatchers.Main) {
            state.collect { movieListState ->
              when(movieListState){
                  is Resources.Success -> {
                      binding?.loadingProgressBar?.visibility = View.GONE
                      binding?.errorMessageTxt?.visibility = View.GONE
                      fillAdapter(movieListState.data,popularMoviesAdapter,MovieListType.Popular)
                      fillAdapter(movieListState.data,nowPlayingMoviesAdapter,MovieListType.NowPlaying)
                      fillAdapter(movieListState.data,topRatedMoviesAdapter,MovieListType.TopRated)
                      fillAdapter(movieListState.data,upComingMoviesAdapter,MovieListType.Upcoming)
                  }
                  is Resources.Loading -> {
                      binding?.loadingProgressBar?.visibility = View.VISIBLE
                      binding?.errorMessageTxt?.visibility = View.GONE
                  }
                  is Resources.Error -> {
                      binding?.loadingProgressBar?.visibility = View.GONE
                      binding?.errorMessageTxt?.text = movieListState.message
                      binding?.errorMessageTxt?.visibility = View.VISIBLE
                  }
              }
            }
        }
        
    }
    
    override fun onResume()
    {
        super.onResume()
        val viewModel: HomeFragmentViewModel by viewModels()
        viewModel.loadMovies()
    }
    
    override fun onPause()
    {
        super.onPause()
        scope.launch(Dispatchers.IO) {
            viewModel.clearMoviesFromRoom()
            viewModel.addMoviesToRoom()
        }
    }
    
    override fun onDestroy()
    {
        super.onDestroy()
        _binding = null
    }
    
    private fun fillAdapter(movieList: List<Movie>, adapter: MovieListAdapter, movieListType: MovieListType){
        val filteredMovies = movieList.filter { it.movieListType == movieListType }
        adapter.setMovieList(filteredMovies)
        adapter.notifyDataSetChanged()
    }
    
    private fun navigateMovieDetail(navController: NavController,movieId: Int){
        val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(movieId)
        navController.navigate(action)
    }
    
}