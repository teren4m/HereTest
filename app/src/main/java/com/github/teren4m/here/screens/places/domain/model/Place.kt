package com.github.teren4m.here.screens.places.domain.model

import com.google.android.gms.maps.model.LatLng

class Place(
    val placeId: String,
    val position: LatLng,
    val distance: Int,
    val title: String,
    val type: String,
    val icon: String,
    val vicinity: String
)