package com.example.kidslearningapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kidslearningapp.util.Graph
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GraphViewModel : ViewModel() {
    private val _stateGraph = MutableStateFlow<Graph>(Graph.ONBOARDING)
    val stateGraph: StateFlow<Graph> = _stateGraph
    fun loadState(graph: Graph) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateGraph.emit(graph)
        }
    }
}