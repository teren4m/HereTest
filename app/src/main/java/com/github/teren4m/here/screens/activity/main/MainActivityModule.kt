package com.github.teren4m.here.screens.activity.main

import com.github.teren4m.here.R
import com.github.teren4m.here.screens.FragmentNavigation
import com.github.teren4m.here.screens.IFragmentNavigation
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun bindsFragmentNavigation(activity: MainActivity): IFragmentNavigation =
        FragmentNavigation(activity, R.id.fragment_container)

}