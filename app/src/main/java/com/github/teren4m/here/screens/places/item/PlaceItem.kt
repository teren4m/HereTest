package com.github.teren4m.here.screens.places.item

import android.text.Spanned
import com.github.teren4m.adapter.delegate.pages.Id
import com.google.android.gms.maps.model.LatLng

data class PlaceItem(
    val placeId: String,
    val position: LatLng,
    val distance: Int,
    val title: String,
    val type: String,
    val icon: String,
    val vicinity: Spanned
) : Id {

    override fun getId(): String = placeId

}