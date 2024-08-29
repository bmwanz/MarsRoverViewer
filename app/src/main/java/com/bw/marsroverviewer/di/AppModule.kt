package com.bw.marsroverviewer.di

import com.bw.marsroverviewer.service.MarsRoverManifestService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesMarsRoverManifestService(): MarsRoverManifestService =
        MarsRoverManifestService.create()

}