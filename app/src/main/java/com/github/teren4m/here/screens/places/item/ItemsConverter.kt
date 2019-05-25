package com.github.teren4m.here.screens.places.item

import android.text.Html
import com.github.teren4m.here.screens.places.domain.model.Place
import javax.inject.Inject

class ItemsConverter @Inject constructor() {

    fun convert(source: Place): PlaceItem =
        PlaceItem(
            placeId = source.placeId,
            position = source.position,
            vicinity = source.vicinity.let(Html::fromHtml),
            type = source.type,
            icon = source.icon,
            distance = source.distance,
            title = source.title
        )

}