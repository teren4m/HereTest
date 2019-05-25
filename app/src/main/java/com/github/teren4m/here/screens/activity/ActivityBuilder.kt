package com.github.teren4m.here.screens.activity

import com.github.teren4m.base.di.ActivityScope
import com.github.teren4m.here.screens.activity.main.MainActivity
import com.github.teren4m.here.screens.activity.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [
            com.github.teren4m.here.screens.activity.main.FragmentBuilder::class,
            MainActivityModule::class
        ]
    )
    @ActivityScope
    abstract fun bindMainActivity(): MainActivity

}