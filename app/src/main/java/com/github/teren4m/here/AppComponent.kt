package com.github.teren4m.here

import com.github.teren4m.here.di.RepositoryModule
import com.github.teren4m.here.di.UseCaseModule
import com.github.teren4m.here.di.UtilsModule
import com.github.teren4m.here.screens.activity.ActivityBuilder
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        UtilsModule::class,
        ActivityBuilder::class,
        UseCaseModule::class,
        RepositoryModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        fun setAppModule(appModule: AppModule): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}