package org.sopt.symphony.util

import android.app.Dialog
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import org.sopt.symphony.R
import org.sopt.symphony.data.model.SymphonyNoteData
import org.sopt.symphony.databinding.DialogNoteDetailBinding

class DialogUtil(private val dialogMode: Int, private val note: SymphonyNoteData) :
    DialogFragment() {
    private var _binding: DialogNoteDetailBinding? = null
    val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return Dialog(requireContext(), R.style.DisableDialogBackground)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogNoteDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Log.d(TAG, "onViewCreated: dialog")
        setLayout(view)
        setVisibilityDependOnDialog()
        clickConfirmListener()
    }

    private fun setVisibilityDependOnDialog() {
        when (dialogMode) {
            SHOW_NOTE -> {
                binding.noteData = note // set data
            }
            COMPLETE_POST -> Log.d(TAG, "setVisibilityDependOnDialog: COMPLETE_POST")
        }
    }

    private fun setLayout(view: View) {
        view.layoutParams.width = (resources.displayMetrics.widthPixels * 0.79).toInt()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun clickConfirmListener() {
        binding.btnConfirm.setOnClickListener { dismiss() }
    }

    companion object {
        const val SHOW_NOTE = 0
        const val COMPLETE_POST = 1
    }
}
