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

class DialogNoteDetail(private val note: SymphonyNoteData?) :
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
        setLayout(view)
        setData()
        clickConfirmListener()
    }

    private fun setData() {
        binding.noteData = note
        Log.d(TAG, "setData: $note")
        binding.starImage = when (note?.scoreType) {
            CHECK_NOTE_DOE -> "https://user-images.githubusercontent.com/59546818/169670775-8916050d-ce40-4bc4-a216-202ca0c71726.png"
            CHECK_NOTE_MI -> "https://user-images.githubusercontent.com/59546818/169670777-b7ec59a2-8784-4897-a464-d7365cac3491.png"
            CHECK_NOTE_SOL -> "https://user-images.githubusercontent.com/59546818/169670778-d9d2a92f-71ff-4ab9-b8cd-7eb5d72f83f4.png"
            CHECK_NOTE_SI -> "https://user-images.githubusercontent.com/59546818/169670779-ff524212-03d0-44bd-96ee-454cb014a580.png"
            CHECK_NOTE_RAE -> "https://user-images.githubusercontent.com/59546818/169670780-4cf0b90e-66fa-439b-a5e2-fa6716c30034.png"
            else -> throw IllegalStateException()
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
}
