package com.okankkl.movieapp.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.okankkl.movieapp.R
import com.okankkl.movieapp.databinding.WatchListDialogBinding

class WatchListDialog(
    val createWatchListClick: () -> Unit,
    val addOrRemoveWatchListClick: () -> Unit,
    val deleteWatchListClick: (Int) -> Unit
) : DialogFragment()
{
    private lateinit var binding : WatchListDialogBinding
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        binding = WatchListDialogBinding.inflate(inflater,container,false)
        val view = binding!!.root
        return view
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        binding.createWatchListBtn.setOnClickListener {
            val watchListName = binding.addWatchListEditText.text.toString()
            if(watchListName.isNotEmpty()){
                createWatchListClick()
            }
        }
        
        super.onViewCreated(view, savedInstanceState)
    }
    
    companion object {
        const val TAG = "WatchListDialog"
    }
    
    
}