package com.github.teren4m.here.network.model

import com.squareup.moshi.Json

class View(

    @field:Json(name = "Result")
    val result: List<ViewResult>?

)