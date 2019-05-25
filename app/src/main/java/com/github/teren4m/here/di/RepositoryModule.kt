package com.github.teren4m.here.di

import com.github.teren4m.here.data.IPlacesRepository
import com.github.teren4m.here.data.PlacesRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindPlacesRepository(repo: PlacesRepository): IPlacesRepository

}