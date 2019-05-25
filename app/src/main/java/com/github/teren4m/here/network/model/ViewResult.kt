package com.github.teren4m.here.network.model

import com.squareup.moshi.Json

class ViewResult(

    @field:Json(name = "Location")
    val location: HereLocation?

)