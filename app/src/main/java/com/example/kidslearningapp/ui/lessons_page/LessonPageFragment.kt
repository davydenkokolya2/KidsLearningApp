package com.example.kidslearningapp.ui.lessons_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kidslearningapp.databinding.FragmentLessonPageBinding
import com.example.kidslearningapp.domain.LessonPageCardModel
import com.example.kidslearningapp.ui.GraphViewModel
import com.example.kidslearningapp.ui.lesson.LessonViewModel
import com.example.kidslearningapp.util.Constant
import com.example.kidslearningapp.util.Graph
import kotlinx.coroutines.launch

class LessonPageFragment : Fragment() {

    private lateinit var binding: FragmentLessonPageBinding
    private val lessonPageViewModel: LessonPageViewModel by activityViewModels()
    private val lessonViewModel: LessonViewModel by activityViewModels()
    private val graphViewModel: GraphViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLessonPageBinding.inflate(inflater, container, false)
        val layoutManager = GridLayoutManager(requireActivity(), 1)
        binding.rvLessonLeft.layoutManager = layoutManager
        val layoutManager2 = GridLayoutManager(requireActivity(), 1)
        binding.rvLessonRight.layoutManager = layoutManager2
        val layoutManager3 = GridLayoutManager(requireActivity(), 1)
        binding.rvLessons.layoutManager = layoutManager3
        lifecycleScope.launch {
            lessonPageViewModel.stateLessonPage.collect {

                val rightListLesson = mutableListOf<LessonPageCardModel>()
                for (i in 0..3)
                {
                    Constant.listLessons[i].progress = (((lessonViewModel.stateLesson.value[i] + 1).toDouble() / Constant.lessons[i].size) * 100).toInt()
                    if (i != it - 1)
                        rightListLesson.add(Constant.listLessons[i])

                }
                val leftListLesson = listOf(Constant.listLessons[it - 1])
                binding.rvLessonLeft.adapter = LessonPageViewAdapter(leftListLesson, ::onClick)
                binding.rvLessonRight.adapter = LessonPageViewAdapter(rightListLesson, ::onClick)
                binding.rvLessons.adapter =
                    LessonsViewAdapter(Constant.lessons[it - 1], ::onClickLesson)

            }
        }
        lifecycleScope.launch {
            lessonViewModel.stateLesson.collect {

                binding.rvLessons.adapter =
                    LessonsViewAdapter(
                        Constant.lessons[lessonPageViewModel.stateLessonPage.value - 1],
                        ::onClickLesson
                    )

            }
        }

        binding.btnLessonChangeChallengeScreen.setOnClickListener {
            graphViewModel.loadState(Graph.CHALLENGE)
        }
        binding.btnLessonPageBack.setOnClickListener {
            graphViewModel.loadState(Graph.SUBJECTS)
        }
        return binding.root
    }

    private fun onClick(position: Int) {
        lessonPageViewModel.loadState(position)
    }

    private fun onClickLesson(position: Int) {
        if (position <= lessonViewModel.stateLesson.value[lessonPageViewModel.stateLessonPage.value - 1]) {
            val list = lessonViewModel.stateLesson.value.toMutableList()
            list[lessonPageViewModel.stateLessonPage.value - 1] = position
            lessonViewModel.loadState(list)
            graphViewModel.loadState(Graph.LESSON)
        }
    }
}