package com.okankkl.movieapp.ui.screen.movie_detail
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.okankkl.movieapp.R
import com.okankkl.movieapp.databinding.FragmentMovieDetailBinding
import com.okankkl.movieapp.domain.model.Movie
import com.okankkl.movieapp.ui.adapter.MovieListAdapter
import com.okankkl.movieapp.ui.dialog.ShareBottomSheetDialog
import com.okankkl.movieapp.util.Constants
import com.okankkl.movieapp.util.Result
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieDetailFragment : Fragment()
{
    private var _binding : FragmentMovieDetailBinding? = null
    val binding get() = _binding!!
    var movieId : Int? = null
    private val viewModel : MovieDetailFragmentViewModel by viewModels()
    private val scope = CoroutineScope(Dispatchers.Main)
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // When fragment created then get movie details if movieId is not wrong
        arguments?.let {
            movieId = it.getInt(Constants.MOVIE_ID_ARG)
            if(movieId != -1){
                viewModel.getMovieDetail(movieId!!)
                viewModel.getSimilarMovies(movieId!!)
            }
        }
    }
    
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailBinding.inflate(inflater)
        val view = binding.root
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        val state = viewModel.state
        val navController = findNavController()
        
        binding.backBtn.setOnClickListener {
            navController.popBackStack(R.id.homeFragment,false)
        }
        
        // Observe state
        scope.launch {
            state.collect{ movieDetailState ->
                when(movieDetailState){
                    is Result.Success -> {
                        val movie = movieDetailState.data
                        binding.loadingProgressBar.visibility = View.GONE
                        fillData(movie)
                        getSimilarMoviesData()
                        createShareBottomSheetDialog(movie)
                    }
                    is Result.Loading -> {
                        binding.loadingProgressBar.visibility = View.VISIBLE
                    }
                    is Result.Error-> {
                        binding.loadingProgressBar.visibility = View.GONE
                        binding.errorMessageTxt.text = movieDetailState.message
                    }
                }
            }
        }
    }
    
    private fun getSimilarMoviesData(){
        scope.launch(Dispatchers.Main) {
            val similarMovies = viewModel.similarMovies.first()
            if(similarMovies.isNotEmpty()){
                binding.similarMoviesTxt.visibility = View.VISIBLE
            }
            val similarContentsAdapter = MovieListAdapter(
                onPosterClick = { movieId ->
                    val action = MovieDetailFragmentDirections.actionMovieDetailFragmentSelf(movieId)
                    findNavController().navigate(action)
                }
            )
            val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            val similarContentsRecyclerView = binding.similarContentsRecyclerView
            similarContentsRecyclerView.layoutManager = linearLayoutManager
            similarContentsRecyclerView.adapter = similarContentsAdapter
            similarContentsAdapter.setMovieList(similarMovies)
            similarContentsAdapter.notifyDataSetChanged()
        }
    }
    
    private fun fillData(movie: Movie){
        binding.apply {
            // fill data to the FlexBoxLayout
            movie.genres.forEach { genre ->
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
            favouriteCheckbox.isChecked = movie.isMovieInFavourite
            favouriteCheckbox.setOnCheckedChangeListener { _, isChecked ->
                if(isChecked){
                    viewModel.addFavorite(movie.id,movie.title,movie.posterPath,movie.backdropPath)
                    Toast.makeText(context,getString(R.string.add_favourites_toast_message),Toast.LENGTH_SHORT).show()
                } else {
                    viewModel.deleteFavourite(movie.id)
                    Toast.makeText(context,getString(R.string.delete_favourites_toast_message),Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    
    private fun createShareBottomSheetDialog(movie: Movie){
        binding.shareBtn.setOnClickListener {
        val movieTrailerUrl = "${Constants.YOUTUBE_VIDEO_URL}${movie.getTrailerVideoKey()}"
        val shareBottomSheetDialog = ShareBottomSheetDialog(movieTrailerUrl)
        activity?.supportFragmentManager?.let { view ->
            shareBottomSheetDialog.show(view, ShareBottomSheetDialog.TAG)
        }
    }
    }
    
    private fun loadMovieTrailer(videoKey: String){
        val youtubePlayerView = binding.youtubePlayerView
        lifecycle.addObserver(youtubePlayerView)
        
        youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoKey,0f)
            }
        })
    }
}