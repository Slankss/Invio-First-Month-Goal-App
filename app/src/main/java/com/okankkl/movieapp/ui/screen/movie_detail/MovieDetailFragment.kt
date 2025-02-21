package com.okankkl.movieapp.ui.screen.movie_detail
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.okankkl.movieapp.R
import com.okankkl.movieapp.data.model.Movie
import com.okankkl.movieapp.databinding.FragmentMovieDetailBinding
import com.okankkl.movieapp.ui.adapter.MovieListAdapter
import com.okankkl.movieapp.ui.adapter.item_decoration.SpaceItemDecoration
import com.okankkl.movieapp.ui.dialog.ShareBottomSheetDialog
import com.okankkl.movieapp.util.Constants
import com.okankkl.movieapp.util.LayoutType
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieDetailFragment : Fragment()
{
    private var _binding : FragmentMovieDetailBinding? = null
    val binding get() = _binding
    var movieId : Int? = null
    private val viewModel : MovieDetailFragmentViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // When fragment created then get movie details if movieId is not wrong
        arguments?.let {
            movieId = it.getInt(Constants.MOVIE_ID_ARG)
        }
    }
    
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailBinding.inflate(inflater)
        val view = binding?.root
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val state = viewModel.state
        
        if(movieId != -1){
            viewModel.getMovieDetail(movieId!!)
        }
        
        binding?.backBtn?.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment,false)
        }
        
        // Observe state
        binding?.apply {
            lifecycleScope.launch {
                state.collect{
                    if(it.movie != null){
                        fillData(it.movie!!,it.isFavourite)
                        loadingProgressBar.visibility = View.GONE
                        errorMessageTxt.visibility = View.GONE
                        createShareBottomSheetDialog(it.movie!!)
                    }
                    if(it.errorMessage.isNotEmpty()){
                        loadingProgressBar.visibility = View.GONE
                        errorMessageTxt.text = it.errorMessage
                    }
                    if(it.isLoading){
                        loadingProgressBar.visibility = View.VISIBLE
                        errorMessageTxt.visibility = View.GONE
                    }
                    if(it.similarMovies != null){
                        getSimilarMoviesData(it.similarMovies!!)
                    }
                }
            }
        }
    }
    
    private fun getSimilarMoviesData(similarMovies : List<Movie>){
        lifecycleScope.launch(Dispatchers.Main) {
            
            if(similarMovies.isNotEmpty()){
                binding?.similarMoviesTxt?.visibility = View.VISIBLE
            }
            val similarContentsAdapter = MovieListAdapter(
                onPosterClick = { movieId ->
                    val action = MovieDetailFragmentDirections.actionMovieDetailFragmentSelf(movieId)
                    findNavController().navigate(action)
                }
            )
            val spaceItemDecoration = SpaceItemDecoration(LayoutType.HorizontalLinear)
            val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            val similarContentsRecyclerView = binding?.similarContentsRecyclerView
            similarContentsRecyclerView?.addItemDecoration(spaceItemDecoration)
            similarContentsRecyclerView?.layoutManager = linearLayoutManager
            similarContentsRecyclerView?.adapter = similarContentsAdapter
            
            similarContentsAdapter.submitList(similarMovies)
        }
    }
    
    private fun fillData(movie: Movie,isFavourite :Boolean){
        binding?.apply {
            // fill data to the FlexBoxLayout
            movie.genres?.forEach { genre ->
                val genreTextView = TextView(context)
                genreTextView.text = genre.name
                genresFlexboxLayout.addView(genreTextView)
            }
            movieReleaseDateTxt.text = movie.releaseDate
            movieTitleTxt.text = movie.title
            movieOverviewTxt.text = movie.overview
            
            // runtime data is 138. I want to convert to 2 hour and 18 minutes
            val hours = movie.runtime / 60
            val minutes = movie.runtime % 60
            val runtimeString = "$hours ${getString(R.string.hour)} $minutes ${getString(R.string.minute)}"
            movieRuntimeTxt.text = runtimeString
            
            // If trailer video key(youtube video key) is not null load trailer video
            val trailerVideoKey = movie.getTrailerVideoKey()
            if(trailerVideoKey != null){
                loadMovieTrailer(trailerVideoKey)
            }
            // If movie is already in favourites then set favourite checkbox to checked
            favouriteCheckbox.isChecked = isFavourite
            favouriteCheckbox.setOnCheckedChangeListener { _, isChecked ->
                if(isChecked){
                    movie.id?.let{ id ->
                        viewModel.addFavorite(id,movie.title,movie.posterPath,movie.backdropPath)
                        Toast.makeText(context,getString(R.string.add_favourites_toast_message),Toast.LENGTH_SHORT).show()
                    }
                } else {
                    movie.id?.let { id ->
                        viewModel.deleteFavourite(id)
                        Toast.makeText(context,getString(R.string.delete_favourites_toast_message),Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
    
    private fun createShareBottomSheetDialog(movie: Movie){
        binding?.shareBtn?.setOnClickListener {
        val movieTrailerUrl = "${Constants.YOUTUBE_VIDEO_URL}${movie.getTrailerVideoKey()}"
        val shareBottomSheetDialog = ShareBottomSheetDialog(movieTrailerUrl)
        activity?.supportFragmentManager?.let { view ->
            shareBottomSheetDialog.show(view, ShareBottomSheetDialog.TAG)
        }
    }
    }
    
    private fun loadMovieTrailer(videoKey: String){
        binding?.apply {
            lifecycle.addObserver(youtubePlayerView)
            youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(videoKey,0f)
                }
            })
        }
    }
}