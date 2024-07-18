package com.okankkl.movieapp.ui.home_screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.okankkl.movieapp.databinding.FragmentHomeBinding
import com.okankkl.movieapp.util.MovieListType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@AndroidEntryPoint
class HomeFragment : Fragment()
{
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding
    private val scope = CoroutineScope(Dispatchers.IO)
    val viewModel: HomeFragmentViewModel by viewModels()
    
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
        
        val popularMoviesAdapter = MovieListAdapter{ movieId ->
            Log.d("MOVIES","movide id = $movieId")
        }
        val nowPlayingMoviesAdapter = MovieListAdapter{ movieId ->
            Log.d("MOVIES","movide id = $movieId")
        }
        val upComingMoviesAdapter = MovieListAdapter{ movieId ->
            Log.d("MOVIES","movide id = $movieId")
        }
        val topRatedMoviesAdapter = MovieListAdapter{ movieId ->
            Log.d("MOVIES","movide id = $movieId")
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
            viewModel.state
            viewModel.state.collect { state ->
                val popularMovies = state.contentList.filter { it.movieListType == MovieListType.Popular }
                val nowPlayingMovies = state.contentList.filter { it.movieListType == MovieListType.NowPlaying }
                val upComingMovies = state.contentList.filter { it.movieListType == MovieListType.Upcoming }
                val topRatedMovies = state.contentList.filter { it.movieListType == MovieListType.TopRated }
                
                popularMoviesAdapter.setMovieList(popularMovies)
                nowPlayingMoviesAdapter.setMovieList(nowPlayingMovies)
                upComingMoviesAdapter.setMovieList(upComingMovies)
                topRatedMoviesAdapter.setMovieList(topRatedMovies)
                
                popularMoviesAdapter.notifyDataSetChanged()
                nowPlayingMoviesAdapter.notifyDataSetChanged()
                upComingMoviesAdapter.notifyDataSetChanged()
                topRatedMoviesAdapter.notifyDataSetChanged()
            }
        }
        
    }
    
    override fun onResume()
    {
        super.onResume()
        val viewModel: HomeFragmentViewModel by viewModels()
        viewModel.getMovies()
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
    
}