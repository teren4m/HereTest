package com.github.teren4m.here.data

import com.github.teren4m.here.data.model.AddressRaw
import com.github.teren4m.here.data.model.PlaceRaw
import com.github.teren4m.here.network.model.HereAddress
import com.github.teren4m.here.network.model.PlaceItem
import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject

class PlacesConverter @Inject constructor() {

    fun convert(source: PlaceItem): PlaceRaw =
        PlaceRaw(
            id = source.id ?: "",
            title = source.title ?: "",
            distance = source.distance ?: 0,
            icon = source.icon ?: "",
            position = source.position?.let {
                if (it.size < 2)
                    error("Wrong position for ${source.title}")

                LatLng(it[0], it[1])
            } ?: error("No position for ${source.title}"),
            type = source.category?.title ?: "",
            vicinity = source.vicinity ?: ""
        )

    fun convert(source: HereAddress): AddressRaw =
        AddressRaw(
            label = source.label ?: "",
            country = source.country ?: "",
            county = source.county ?: "",
            city = source.city ?: "",
            district = source.district ?: "",
            houseNumber = source.houseNumber ?: "",
            postalCode = source.postalCode ?: "",
            street = source.street ?: ""
        )

}