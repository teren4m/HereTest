package com.github.teren4m.here.screens.search

import android.location.Location
import androidx.lifecycle.MutableLiveData
import com.github.teren4m.base.mvvm.BaseViewModel
import com.github.teren4m.base.mvvm.SingleLiveEvent
import com.github.teren4m.base.setupAndSubscribe
import com.github.teren4m.here.Constants
import com.github.teren4m.here.screens.places.domain.IPlacesUseCase
import com.github.teren4m.here.screens.search.item.ItemsConverter
import com.github.teren4m.here.screens.search.item.TypeItem
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val placesUseCase: IPlacesUseCase,
    converter: ItemsConverter
) : ISearchViewModel, BaseViewModel() {

    override val showPlaces = SingleLiveEvent<PlaceItem>()
    override val types = MutableLiveData<List<TypeItem>>()
    override val isSearchAvailable = MutableLiveData<Boolean>()
    override val address = MutableLiveData<String>()

    private lateinit var location: Location

    init {
        isSearchAvailable.value = false

        types.value = Constants.TYPES.map(converter::convert)
    }

    override fun updateLocation(location: Location) {
        this.location = location
        isSearchAvailable.value = true
        placesUseCase.reverseGeocode(location.latitude, location.longitude)
            .setupAndSubscribe(
                onNext = {
                    address.value = it
                },
                onError = {
                    //TODO show error
                }
            )
            .addDisposable()
    }

    override fun search() {
        showPlaces.value = PlaceItem(
            location = location,
            types = getTypes()
        )
    }

    private fun getTypes(): Array<String> =
        types.value
            ?.filter { it.isChecked }
            ?.map { it.type }
            ?.toTypedArray()
            ?: emptyArray()

}