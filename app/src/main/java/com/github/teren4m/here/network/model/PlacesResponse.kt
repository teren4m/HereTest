package com.github.teren4m.here.network.model

import com.squareup.moshi.Json

class PlacesResponse(

    @field:Json(name = "results")
    val response: Result?

)

class Result(
    @field:Json(name = "items")
    val items: List<PlaceItem>?
)