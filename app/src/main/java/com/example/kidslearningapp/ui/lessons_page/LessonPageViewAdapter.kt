package com.example.kidslearningapp.ui.lessons_page

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kidslearningapp.databinding.ItemLessonCardBinding
import com.example.kidslearningapp.domain.LessonPageCardModel

class LessonPageViewAdapter(
    data: List<LessonPageCardModel>, val onClick: (Int) -> Unit
) : RecyclerView.Adapter<LessonPageViewAdapter.StringViewHolder>() {

    var list: List<LessonPageCardModel> = data
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class StringViewHolder(
        val binding: ItemLessonCardBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLessonCardBinding.inflate(inflater, parent, false)

        return StringViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvLessonCardTitle.setText(item.title)
        holder.binding.ProgressBar2.max = 100
        holder.binding.ProgressBar2.progress = item.progress
        holder.binding.tvLessonCardLectures.setText(item.lectures)
        holder.binding.tvLessonCardProgress.text = "${item.progress}%"
        holder.binding.imageView9.setOnClickListener {
            onClick(item.number)
        }
    }
}