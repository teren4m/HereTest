package com.github.teren4m.here.screens.search

import android.location.Location
import androidx.lifecycle.LiveData
import com.github.teren4m.here.screens.search.item.TypeItem

interface ISearchViewModel {

    val showPlaces: LiveData<PlaceItem>
    val address: LiveData<String>
    val isSearchAvailable: LiveData<Boolean>
    val types: LiveData<List<TypeItem>>

    fun updateLocation(location: Location)
    fun search()

}

class PlaceItem(
    val location: Location,
    val types: Array<String>
)