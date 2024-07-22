package com.okankkl.movieapp.ui.dialog
import android.app.Dialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.okankkl.movieapp.R
import com.okankkl.movieapp.databinding.ShareMovieBottomSheetDialogBinding
import com.okankkl.movieapp.util.OtherApplication

class ShareBottomSheetDialog(val movieTrailerUrl : String) : BottomSheetDialogFragment()
{
    private lateinit var binding: ShareMovieBottomSheetDialogBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View
    {
        binding = ShareMovieBottomSheetDialogBinding.inflate(inflater,container,false)
        return binding.root
    }
    
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {
        dialog?.setOnShowListener { dialogInterface ->
            val dialog = dialogInterface as BottomSheetDialog
            val bottomSheet = dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.let {
                val behavior = BottomSheetBehavior.from(it)
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return super.onCreateDialog(savedInstanceState)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding.sendLinkWithWhatsappBtn.setOnClickListener {
            // Explicit Intent
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, movieTrailerUrl)
            intent.setType("text/plain")
            intent.setPackage("com.whatsapp")
            startActivity(intent)
        }
        binding.sendLinkWithInstragramBtn.setOnClickListener {
            // Implicit Intent
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, movieTrailerUrl)
            intent.setType("text/plain")
            try {
                startActivity(intent)
            } catch(exception : android.content.ActivityNotFoundException){
                val errorMessage = getString(R.string.whatsapp_not_installed)
                Toast.makeText(context,errorMessage,Toast.LENGTH_SHORT).show()
            }
        }
        binding.copyLinkBtn.setOnClickListener {
            context?.let {
                val clipboard: ClipboardManager? = getSystemService(it.applicationContext, ClipboardManager::class.java)
                val clip = ClipData.newPlainText("movie_trailer_url", movieTrailerUrl)
                clipboard!!.setPrimaryClip(clip)
            }
        }
    }
    
    companion object {
        const val TAG = "ShareBottomSheetDialog"
    }
}