package com.example.kidslearningapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.kidslearningapp.R
import com.example.kidslearningapp.ui.challenge.ChallengeFragment
import com.example.kidslearningapp.ui.lesson.LessonFragment
import com.example.kidslearningapp.ui.lessons_page.LessonPageFragment
import com.example.kidslearningapp.ui.onboarding.OnboardingFragment
import com.example.kidslearningapp.ui.subjects.SubjectsFragment
import com.example.kidslearningapp.util.Graph
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val graphViewModel: GraphViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            graphViewModel.stateGraph.collect {
                when(it) {
                    Graph.ONBOARDING -> replaceFragment(OnboardingFragment())
                    Graph.LESSON -> replaceFragment(LessonFragment())
                    Graph.LESSONS_PAGE -> replaceFragment(LessonPageFragment())
                    Graph.CHALLENGE -> replaceFragment(ChallengeFragment())
                    Graph.SUBJECTS -> replaceFragment(SubjectsFragment())
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}