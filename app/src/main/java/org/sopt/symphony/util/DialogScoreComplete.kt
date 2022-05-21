package org.sopt.symphony.util

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import org.sopt.symphony.R
import org.sopt.symphony.databinding.DialogScoreCompleteBinding

class DialogScoreComplete(private val doAfterConfirm: () -> Unit) :
    DialogFragment() {
    private var _binding: DialogScoreCompleteBinding? = null
    val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return Dialog(requireContext(), R.style.DisableDialogBackground)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogScoreCompleteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setLayout(view)
        clickConfirmListener()
    }

    private fun setLayout(view: View) {
        view.layoutParams.width = (resources.displayMetrics.widthPixels * 0.79).toInt()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun clickConfirmListener() {
        binding.btnConfirm.setOnClickListener {
            dismiss()
            doAfterConfirm()
        }
    }
}
