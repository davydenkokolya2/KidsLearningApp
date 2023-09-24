package com.example.kidslearningapp.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.kidslearningapp.R
import com.example.kidslearningapp.databinding.FragmentOnboardingBinding
import com.example.kidslearningapp.ui.GraphViewModel
import com.example.kidslearningapp.util.Graph
import kotlinx.coroutines.launch

class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding
    private val onboardingViewModel: OnboardingViewModel by activityViewModels()
    private val graphViewModel: GraphViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)

        lifecycleScope.launch {
            onboardingViewModel.stateOnboarding.collect{
                when(it) {
                    0 -> {
                        binding.ivOnboarding.setImageResource(R.drawable.icon_image_onboarding_1)
                        binding.tvOnboarding.setText(R.string.onboarding_1)
                    }
                    1 -> {
                        binding.ivOnboarding.setImageResource(R.drawable.icon_image_onboarding_2)
                        binding.tvOnboarding.setText(R.string.onboarding_2)
                    }
                }
            }
        }

        binding.btnOnboardingNext.setOnClickListener {
            if (onboardingViewModel.stateOnboarding.value == 0)
                onboardingViewModel.loadState(1)
            else
                graphViewModel.loadState(Graph.SUBJECTS)
        }
        return binding.root
    }

}