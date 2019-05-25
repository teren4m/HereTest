package com.github.teren4m.here.screens.places

import androidx.lifecycle.LiveData
import com.google.android.gms.maps.model.LatLng

interface IMapViewModel {

    val destinationPlace: LiveData<LatLng>

    fun moveToPlace(place: LatLng)

}