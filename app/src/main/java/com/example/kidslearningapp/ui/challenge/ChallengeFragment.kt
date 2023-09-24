package com.example.kidslearningapp.ui.challenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kidslearningapp.databinding.FragmentChallengeBinding
import com.example.kidslearningapp.ui.GraphViewModel
import com.example.kidslearningapp.util.Constant
import com.example.kidslearningapp.util.Graph

class ChallengeFragment : Fragment() {

    private lateinit var binding: FragmentChallengeBinding
    private val graphViewModel: GraphViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChallengeBinding.inflate(inflater, container, false)
        val layoutManager = GridLayoutManager(requireActivity(), 4)
        binding.rvChallenge.layoutManager = layoutManager
        binding.rvChallenge.adapter = ChallengeViewAdapter(Constant.listChallenge, requireActivity())
        binding.btnHome.setOnClickListener {
            graphViewModel.loadState(Graph.SUBJECTS)
        }
        return binding.root
    }
}