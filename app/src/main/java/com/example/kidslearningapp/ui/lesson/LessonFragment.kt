package com.example.kidslearningapp.ui.lesson

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.kidslearningapp.R
import com.example.kidslearningapp.databinding.FragmentLessonBinding
import com.example.kidslearningapp.ui.GraphViewModel
import com.example.kidslearningapp.ui.lessons_page.LessonPageViewModel
import com.example.kidslearningapp.util.Constant
import com.example.kidslearningapp.util.Graph
import kotlinx.coroutines.launch

class LessonFragment : Fragment() {
    private lateinit var binding: FragmentLessonBinding
    private val lessonViewModel: LessonViewModel by activityViewModels()
    private val lessonPageViewModel: LessonPageViewModel by activityViewModels()
    private val graphViewModel: GraphViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLessonBinding.inflate(inflater, container, false)

        lifecycleScope.launch {
            lessonViewModel.stateLesson.collect {
                val i = lessonPageViewModel.stateLessonPage.value - 1
                for (j in 0..it[i]) {
                    Constant.lessons[i][j].apply {
                        lock = R.drawable.icon_unlock
                        play = R.drawable.icon_btn_play_black
                        current = it[i]
                    }
                }
                for (j in Constant.lessons[i])
                    j.play = R.drawable.icon_btn_play_black
                Constant.lessons[i][it[i]].apply {
                    play = R.drawable.icon_btn_play_blue
                    current = it[i]
                }
                binding.tvLessonTitle.setText(Constant.lessons[i][it[i]].title)
                binding.tvLessonDescription.setText(Constant.lessons[i][it[i]].description)
            }
        }

        binding.btnNextLesson.setOnClickListener {
            val list = lessonViewModel.stateLesson.value.toMutableList()
            if (Constant.lessons[lessonPageViewModel.stateLessonPage.value - 1].size > list[lessonPageViewModel.stateLessonPage.value - 1] + 1)
                list[lessonPageViewModel.stateLessonPage.value - 1]++
            lessonViewModel.loadState(list)
        }
        binding.btnLessonBack.setOnClickListener {
            graphViewModel.loadState(Graph.LESSONS_PAGE)
        }
        return binding.root
    }
}