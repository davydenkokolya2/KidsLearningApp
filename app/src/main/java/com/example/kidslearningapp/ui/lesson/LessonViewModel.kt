package com.example.kidslearningapp.ui.lesson

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LessonViewModel : ViewModel() {
    private val _stateLesson = MutableStateFlow<MutableList<Int>>(mutableListOf(0, 0, 0, 0))
    val stateLesson: StateFlow<MutableList<Int>> = _stateLesson
    fun loadState(lesson: MutableList<Int>) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateLesson.emit(lesson)
        }
    }
}