package com.github.teren4m.here.screens.places

import android.location.Location
import androidx.lifecycle.LiveData
import com.github.teren4m.here.screens.places.item.PlaceItem

interface IPlacesViewModel {

    val places: LiveData<List<PlaceItem>>
    val progress: LiveData<Boolean>
    val currentLocation: LiveData<Location>

}