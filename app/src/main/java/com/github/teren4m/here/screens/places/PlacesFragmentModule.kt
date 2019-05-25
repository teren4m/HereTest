package com.github.teren4m.here.screens.places

import android.location.Location
import com.github.teren4m.adapter.delegate.CompositeDelegateAdapter
import com.github.teren4m.base.getViewModel
import com.github.teren4m.here.screens.places.item.PlaceAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class PlacesFragmentModule {

    @Provides
    fun providePlacesViewModel(
        fragment: PlacesFragment,
        viewModel: Provider<PlacesViewModel>
    ): IPlacesViewModel =
        getViewModel<PlacesViewModel>(fragment) {
            viewModel.get()
        }

    @Provides
    fun provideMapViewModel(placesViewModel: IPlacesViewModel): IMapViewModel =
        placesViewModel as IMapViewModel

    @Provides
    fun provideAdapter(placeAdapter: PlaceAdapter): CompositeDelegateAdapter =
        CompositeDelegateAdapter.Builder()
            .add(placeAdapter)
            .build()

    @Provides
    fun provideTypes(fragment: PlacesFragment): List<String> =
        fragment.arguments?.getStringArray(PlacesFragment.KEY_TYPES)?.toList() ?: emptyList()

    @Provides
    fun provideLocation(fragment: PlacesFragment): Location =
        fragment.arguments?.getParcelable(PlacesFragment.KEY_LOCATION) ?: error("Location not provided")

}