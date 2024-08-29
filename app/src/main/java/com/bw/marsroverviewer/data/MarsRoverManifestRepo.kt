package com.bw.marsroverviewer.data

import com.bw.marsroverviewer.domain.model.RoverManifestUiState
import com.bw.marsroverviewer.domain.model.toUiModel
import com.bw.marsroverviewer.service.MarsRoverManifestService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MarsRoverManifestRepo @Inject constructor(
    private val marsRoverManifestService: MarsRoverManifestService
) {

    fun getMarsRoverManifest(roverName: String) : Flow<RoverManifestUiState> = flow {
        try {
            emit(
                toUiModel(
                    marsRoverManifestService.getMarsRoverManifest(
                        roverName.lowercase()
                    )
                )
            )
        } catch (throwable: Throwable) {
            emit(RoverManifestUiState.Error)
        }
    }

}