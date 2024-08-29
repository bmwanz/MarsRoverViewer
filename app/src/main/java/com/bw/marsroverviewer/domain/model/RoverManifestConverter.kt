package com.bw.marsroverviewer.domain.model

import com.bw.marsroverviewer.service.model.RoverManifestRemoteModel

fun toUiModel(roverManifestRemoteModel: RoverManifestRemoteModel) : RoverManifestUiState =
    RoverManifestUiState.Success(roverManifestRemoteModel.photoManifest.photos.map {
        photo ->
        RoverManifestUiModel(
            sol = photo.sol.toString(),
            earthDate = photo.earthDate.toString(),
            photoNumber = photo.totalPhotos.toString()
        )
    }.sorted())