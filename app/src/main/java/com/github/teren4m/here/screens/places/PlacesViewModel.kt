package com.github.teren4m.here.screens.places

import android.location.Location
import androidx.lifecycle.MutableLiveData
import com.github.teren4m.base.mvvm.BaseViewModel
import com.github.teren4m.base.setupAndSubscribe
import com.github.teren4m.here.screens.places.domain.IPlacesUseCase
import com.github.teren4m.here.screens.places.item.ItemsConverter
import com.github.teren4m.here.screens.places.item.PlaceItem
import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject

class PlacesViewModel @Inject constructor(
    location: Location,
    types: List<String>,
    placesUseCase: IPlacesUseCase,
    itemsConverter: ItemsConverter
) : IPlacesViewModel, IMapViewModel, BaseViewModel() {

    override val destinationPlace = MutableLiveData<LatLng>()
    override val currentLocation = MutableLiveData<Location>()
    override val progress = MutableLiveData<Boolean>()
    override val places = MutableLiveData<List<PlaceItem>>()

    init {
        currentLocation.value = location
        progress.value = true
        placesUseCase.explore(location.latitude, location.longitude, types)
            .map(itemsConverter::convert)
            .toList()
            .setupAndSubscribe(
                onSuccess = {
                    places.value = it
                    progress.value = false
                },
                onError = {
                    //TODO show error
                    progress.value = false
                }
            )
            .addDisposable()
    }

    override fun moveToPlace(place: LatLng) {
        destinationPlace.value = place
    }

}