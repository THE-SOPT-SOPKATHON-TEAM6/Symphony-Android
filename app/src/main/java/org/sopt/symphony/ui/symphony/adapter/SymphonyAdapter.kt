package org.sopt.symphony.ui.symphony.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.symphony.data.SymphonyNoteData
import org.sopt.symphony.databinding.ItemNoteForSymphonyBinding

class SymphonyAdapter(
    private val onNoteClick: ((SymphonyNoteData) -> Unit)
) : ListAdapter<SymphonyNoteData, SymphonyAdapter.ViewHolder>(NoteForSymphonyComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemNoteForSymphonyBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = getItem(position)
        holder.bind(note, onNoteClick)
    }

    class ViewHolder(
        private val binding: ItemNoteForSymphonyBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(noteData: SymphonyNoteData, onNoteClick: (SymphonyNoteData) -> Unit) {
            binding.note = noteData.scoreImage
            binding.root.setOnClickListener { onNoteClick(noteData) }
        }
    }

    private class NoteForSymphonyComparator : DiffUtil.ItemCallback<SymphonyNoteData>() {
        override fun areItemsTheSame(oldItem: SymphonyNoteData, newItem: SymphonyNoteData) =
            oldItem.createdAt == newItem.createdAt

        override fun areContentsTheSame(oldItem: SymphonyNoteData, newItem: SymphonyNoteData) =
            oldItem == newItem
    }
}
