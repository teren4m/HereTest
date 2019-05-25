package com.github.teren4m.here.screens.places.domain

import com.github.teren4m.here.data.model.AddressRaw
import com.github.teren4m.here.data.model.PlaceRaw
import com.github.teren4m.here.screens.places.domain.model.Place
import javax.inject.Inject

class PlacesConverter @Inject constructor() {

    fun convert(source: AddressRaw): String =
        source.label

    fun convert(source: PlaceRaw): Place =
        Place(
            placeId = source.id,
            position = source.position,
            vicinity = source.vicinity,
            type = source.type,
            icon = source.icon,
            distance = source.distance,
            title = source.title
        )

}