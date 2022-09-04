package com.sihabudin.learngooglemaps2022

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sihabudin.learngooglemaps2022.databinding.ItemOptionSubjectBinding

class OptionSubjectAdapter : RecyclerView.Adapter<OptionSubjectAdapter.ListViewHolder>() {
    private var listSubject = ArrayList<String>()

    var onItemClick: ((String) -> Unit)? = null

    fun setData(newListSubject: List<String>?) {
        if (newListSubject == null) return
        listSubject.clear()
        listSubject.addAll(newListSubject)
        notifyDataSetChanged()
    }

    override fun getItemCount() = listSubject.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder = ListViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_option_subject, parent, false)
    )

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemOptionSubjectBinding.bind(itemView)
        fun bind(data: String) {
            binding.tvSubject.text = data
        }
        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listSubject[adapterPosition])
            }
        }


    }


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listSubject[position]
        holder.bind(data)
    }

}