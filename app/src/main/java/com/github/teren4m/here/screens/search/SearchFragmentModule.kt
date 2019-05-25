package com.github.teren4m.here.screens.search

import com.github.teren4m.adapter.delegate.CompositeDelegateAdapter
import com.github.teren4m.base.getViewModel
import com.github.teren4m.here.Constants
import com.github.teren4m.here.screens.search.item.TypeAdapter
import com.google.android.gms.location.LocationRequest
import com.patloew.rxlocation.RxLocation
import com.tbruyelle.rxpermissions2.RxPermissions
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class SearchFragmentModule {

    @Provides
    fun providePlacesViewModel(
        fragment: SearchFragment,
        viewModel: Provider<SearchViewModel>
    ): ISearchViewModel =
        getViewModel<SearchViewModel>(fragment) {
            viewModel.get()
        }

    @Provides
    fun provideRxPermissions(fragment: SearchFragment) = RxPermissions(fragment)

    @Provides
    fun provideRxLocation(fragment: SearchFragment) = RxLocation(fragment.context!!)

    @Provides
    fun provideLocationRequest(): LocationRequest =
        LocationRequest.create()
            .setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY)
            .setInterval(Constants.GPS_INTERVAL)

    @Provides
    fun provideAdapter(typeAdapter: TypeAdapter): CompositeDelegateAdapter =
        CompositeDelegateAdapter.Builder()
            .add(typeAdapter)
            .build()

}