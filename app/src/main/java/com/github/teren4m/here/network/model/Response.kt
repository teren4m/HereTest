package com.github.teren4m.here.network.model

import com.squareup.moshi.Json

class Response(

    @field:Json(name = "View")
    val views: List<View>?

)