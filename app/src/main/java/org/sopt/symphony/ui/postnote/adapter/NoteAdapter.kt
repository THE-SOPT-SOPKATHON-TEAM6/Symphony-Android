package org.sopt.symphony.ui.postnote.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.symphony.data.NoteData
import org.sopt.symphony.databinding.ItemNoteBinding

class NoteAdapter:RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    var noteList = mutableListOf<NoteData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NoteHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.onBind(noteList[position])
    }

    override fun getItemCount(): Int = noteList.size

    class NoteHolder(private val binding: ItemNoteBinding):RecyclerView.ViewHolder(binding.root){
        fun onBind(data:NoteData){
            binding.noteRecycler = data
        }
    }
}