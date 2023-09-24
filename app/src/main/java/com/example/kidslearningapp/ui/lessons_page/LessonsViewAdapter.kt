package com.example.kidslearningapp.ui.lessons_page

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kidslearningapp.databinding.ItemLessonBinding
import com.example.kidslearningapp.domain.LessonsModel

class LessonsViewAdapter(
    data: List<LessonsModel>, val onClick: (Int) -> Unit
) : RecyclerView.Adapter<LessonsViewAdapter.StringViewHolder>() {

    var list: List<LessonsModel> = data
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class StringViewHolder(
        val binding: ItemLessonBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLessonBinding.inflate(inflater, parent, false)

        return StringViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        val item = list[position]
        holder.binding.btnLock.setImageResource(item.lock)
        holder.binding.tvTime.setText(item.time)
        holder.binding.tvTitle.setText(item.title)
        holder.binding.btnPlay.setImageResource(item.play)
        holder.binding.root.setOnClickListener {
            onClick(position)
        }
    }
}