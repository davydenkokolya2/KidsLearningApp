package com.example.kidslearningapp.ui.challenge

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.kidslearningapp.databinding.ItemChallengeCardBinding
import com.example.kidslearningapp.domain.ChallengeCardModel

class ChallengeViewAdapter(
    data: List<ChallengeCardModel>, val context: Context
) : RecyclerView.Adapter<ChallengeViewAdapter.StringViewHolder>() {

    var list: List<ChallengeCardModel> = data
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class StringViewHolder(
        val binding: ItemChallengeCardBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemChallengeCardBinding.inflate(inflater, parent, false)

        return StringViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        val item = list[position]
        holder.binding.imageView5.setImageResource(item.image)
        holder.binding.textView11.setText(item.name)
        holder.binding.progressBar.max = 100
        holder.binding.progressBar.progress = item.progress
        holder.binding.progressBar.setProgressDrawableTiled(ContextCompat.getDrawable(context, item.drawable))
        holder.binding.textView17.text = "${item.progress}%"
    }
}