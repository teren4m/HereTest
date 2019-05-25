package com.github.teren4m.here.di

import com.github.teren4m.here.screens.places.domain.IPlacesUseCase
import com.github.teren4m.here.screens.places.domain.PlacesUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseModule {

    @Binds
    abstract fun bindPlacesUseCase(useCase: PlacesUseCase): IPlacesUseCase

}