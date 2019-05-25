package com.github.teren4m.here.data.model

import com.google.android.gms.maps.model.LatLng

class PlaceRaw(

    val id: String,
    val position: LatLng,
    val distance: Int,
    val title: String,
    val type: String,
    val icon: String,
    val vicinity: String

)