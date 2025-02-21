package com.okankkl.movieapp.ui.screen.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.okankkl.movieapp.R
import com.okankkl.movieapp.databinding.FragmentFavouritesBinding
import com.okankkl.movieapp.ui.adapter.FavouritesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavouritesFragment : Fragment()
{
    private var _binding : FragmentFavouritesBinding? = null
    private val binding get() = _binding
    private val viewModel: FavouritesFragmentViewModel by viewModels()
    
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavouritesBinding.inflate(inflater,container,false)
        val view = binding?.root
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val state = viewModel.state
        
        val favouritesAdapter = FavouritesAdapter(
            onCardClick = { movieId ->
               val action = FavouritesFragmentDirections.actionFavouritesFragmentToMovieDetailFragment(movieId)
               findNavController().navigate(action)
            },
            onDeleteClick = { movieId ->
                alertDialog {
                    viewModel.deleteFavourite(movieId)
                }
            }
        )
        
        binding?.apply {
            val layoutManager = LinearLayoutManager(requireContext())
            favouritesRecyclerView.layoutManager = layoutManager
            favouritesRecyclerView.adapter = favouritesAdapter
            
            lifecycleScope.launch {
                state.collect{
                    if(it.isLoading){
                        loadingProgressBar.visibility = View.VISIBLE
                        errorMessageTxt.visibility = View.GONE
                    }
                    if(it.favourites != null){
                        loadingProgressBar.visibility = View.GONE
                        errorMessageTxt.visibility = View.GONE
                        favouritesAdapter.submitList(it.favourites)
                    }
                    if(it.errorMessage.isNotEmpty()){
                        loadingProgressBar.visibility = View.GONE
                        errorMessageTxt.visibility = View.VISIBLE
                        errorMessageTxt.text = it.errorMessage
                        favouritesAdapter.submitList(emptyList())
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
    
    override fun onResume() {
        super.onResume()
        viewModel.getFavouritesList()
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}