package com.example.kidslearningapp.ui.subjects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.kidslearningapp.databinding.FragmentSubjectsBinding
import com.example.kidslearningapp.ui.GraphViewModel
import com.example.kidslearningapp.util.Graph

class SubjectsFragment : Fragment() {

    private val graphViewModel: GraphViewModel by activityViewModels()
    private lateinit var binding: FragmentSubjectsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubjectsBinding.inflate(inflater, container, false)
        binding.btnChallengeScreen.setOnClickListener {
            graphViewModel.loadState(Graph.CHALLENGE)
        }
        binding.btnArabic.setOnClickListener {
            graphViewModel.loadState(Graph.LESSONS_PAGE)
        }
        binding.btnChallenge.setOnClickListener {
            graphViewModel.loadState(Graph.LESSONS_PAGE)
        }
        binding.btnArts.setOnClickListener {
            graphViewModel.loadState(Graph.LESSONS_PAGE)
        }
        binding.btnExam.setOnClickListener {
            graphViewModel.loadState(Graph.LESSONS_PAGE)
        }
        binding.btnScince.setOnClickListener {
            graphViewModel.loadState(Graph.LESSONS_PAGE)
        }
        binding.btnSocialScince.setOnClickListener {
            graphViewModel.loadState(Graph.LESSONS_PAGE)
        }
        binding.btnIslamicStudy.setOnClickListener {
            graphViewModel.loadState(Graph.LESSONS_PAGE)
        }
        binding.btnMath.setOnClickListener {
            graphViewModel.loadState(Graph.LESSONS_PAGE)
        }

        return binding.root
    }

}