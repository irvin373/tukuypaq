package com.example.tukuypacandroid.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tukuypacandroid.R
import com.example.tukuypacandroid.data.model.MedicalGroup

class MedicalGroupListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<MedicalGroupListAdapter.WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var groups = emptyList<MedicalGroup>() // Cached copy of words

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = groups[position]
        holder.wordItemView.text = current.name
    }

    internal fun setWords(groups: List<MedicalGroup>) {
        this.groups = groups
        notifyDataSetChanged()
    }

    override fun getItemCount() = groups.size
}