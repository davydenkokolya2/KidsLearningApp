package com.example.kidslearningapp.ui.lessons_page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LessonPageViewModel : ViewModel() {
    private val _stateLessonPage = MutableStateFlow<Int>(1)
    val stateLessonPage: StateFlow<Int> = _stateLessonPage
    fun loadState(lessonPage: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateLessonPage.emit(lessonPage)
        }
    }
}