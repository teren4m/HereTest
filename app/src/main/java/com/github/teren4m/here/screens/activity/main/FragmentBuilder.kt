package com.github.teren4m.here.screens.activity.main

import ai.sync.daggerx.FragmentScope
import com.github.teren4m.here.screens.places.PlacesFragment
import com.github.teren4m.here.screens.places.PlacesFragmentModule
import com.github.teren4m.here.screens.search.SearchFragment
import com.github.teren4m.here.screens.search.SearchFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(
        modules = [
            PlacesFragmentModule::class
        ]
    )
    @FragmentScope
    abstract fun bindPlacesFragment(): PlacesFragment

    @ContributesAndroidInjector(
        modules = [
            SearchFragmentModule::class
        ]
    )
    @FragmentScope
    abstract fun bindSearchFragment(): SearchFragment

}