package com.bw.marsroverviewer.ui.manifestlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bw.marsroverviewer.data.MarsRoverManifestRepo
import com.bw.marsroverviewer.domain.model.RoverManifestUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarsRoverManifestViewModel @Inject constructor(
    private val marsRoverManifestRepo: MarsRoverManifestRepo
) : ViewModel() {

    // initialize state to loading
    private val _roverManifestUiState: MutableStateFlow<RoverManifestUiState> =
        MutableStateFlow(RoverManifestUiState.Loading)
    val roverManifestUiState: StateFlow<RoverManifestUiState>
        get() = _roverManifestUiState

    fun getMarsRoverManifest(roverName: String) {
        viewModelScope.launch {
            _roverManifestUiState.value = RoverManifestUiState.Loading
            marsRoverManifestRepo.getMarsRoverManifest(roverName).collect {
                _roverManifestUiState.value = it
            }
        }
    }

}