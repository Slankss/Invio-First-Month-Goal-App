package com.okankkl.movieapp.ui.screen.favourites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.okankkl.movieapp.R
import com.okankkl.movieapp.databinding.FragmentFavouritesBinding
import com.okankkl.movieapp.ui.adapter.FavouritesAdapter
import com.okankkl.movieapp.util.Result
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavouritesFragment : Fragment()
{
    private var _binding : FragmentFavouritesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FavouritesFragmentViewModel by viewModels()
    private val scope = CoroutineScope(Dispatchers.Main)
    
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouritesBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        val state = viewModel.state
        
        val favouritesAdapter = FavouritesAdapter(
            onCardClick = { movieId ->
               val action = FavouritesFragmentDirections.actionFavouritesFragmentToMovieDetailFragment(movieId)
               navController.navigate(action)
            },
            onDeleteClick = { movieId ->
                alertDialog {
                    viewModel.deleteFavourite(movieId)
                }
            }
        )
        
        val recyclerView = binding.favouritesRecyclerView
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = favouritesAdapter
        
        scope.launch {
            state.collect{
                when(it){
                    is Result.Success -> {
                        binding.apply {
                            loadingProgressBar.visibility = View.GONE
                            errorMessageTxt.visibility = View.GONE
                        }
                        favouritesAdapter.setData(it.data)
                        favouritesAdapter.notifyDataSetChanged()
                    }
                    is Result.Initial -> {
                        if(it.isLoading){
                            binding.apply {
                                loadingProgressBar.visibility = View.VISIBLE
                                errorMessageTxt.visibility = View.GONE
                            }
                        }
                    }
                    is Result.Error -> {
                        favouritesAdapter.setData(emptyList())
                        favouritesAdapter.notifyDataSetChanged()
                        binding.apply {
                            loadingProgressBar.visibility = View.GONE
                            errorMessageTxt.text = it.message
                            errorMessageTxt.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }
    
   private fun alertDialog(onPositiveButtonClick:()-> Unit) = AlertDialog.Builder(requireContext())
        .setMessage(getString(R.string.delete_alert_dialog_title))
        .setPositiveButton(getString(R.string.yes)){ _, _ ->
            onPositiveButtonClick()
        }
        .setNegativeButton(getString(R.string.no)){ dialog, _ ->
            dialog.dismiss()
        }
        .create()
        .show()
    
    override fun onPause() {
        super.onPause()
        viewModel.clearState()
    }
    
    override fun onResume() {
        super.onResume()
        viewModel.getFavouritesList()
    }
}