package com.okankkl.movieapp.ui.screen.viewall

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.okankkl.movieapp.databinding.FragmentViewAllBinding
import com.okankkl.movieapp.ui.adapter.MovieListAdapter
import com.okankkl.movieapp.util.Constants.MOVIE_TYPE_ARG
import com.okankkl.movieapp.util.Constants.MOVIE_TYPE_STRING_ID_ARG
import com.okankkl.movieapp.util.LayoutType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ViewAllFragment : Fragment()
{
    private var _binding : FragmentViewAllBinding? = null
    val binding get() = _binding
    var movieTypeRouteName : String? = null
    var movieTypeNameStringId: Int = 0
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
        
        var lastMovieId = 0
        val adapter = MovieListAdapter(
            layoutType = LayoutType.Grid,
            onPosterClick = { movieId ->
                val action = ViewAllFragmentDirections.actionViewAllFragmentToMovieDetailFragment(movieId)
                findNavController().navigate(action)
            },
            onLoad = { id ->
                movieTypeRouteName?.let {
                    viewModel.loadMovies(it)
                    lastMovieId = id
                }
            }
        )
        val recyclerView = binding?.moviesRecyclerView
        val layoutManager = GridLayoutManager(requireContext(),3,GridLayoutManager.VERTICAL,false)
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = layoutManager
        
        lifecycleScope.launch {
            state.collect {
                Log.d("EMINEM","${it.movies}")
                if(it.movies != null) {
                    adapter.setMovieList(it.movies!!)
                    adapter.notifyItemRangeChanged(lastMovieId, it.pageSize)
                }
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}