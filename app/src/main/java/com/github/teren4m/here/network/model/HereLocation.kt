package com.github.teren4m.here.network.model

import com.squareup.moshi.Json

class HereLocation(

    @field:Json(name = "Address")
    val address: HereAddress?

)