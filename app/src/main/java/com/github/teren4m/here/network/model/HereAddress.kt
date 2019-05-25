package com.github.teren4m.here.network.model

import com.squareup.moshi.Json

class HereAddress(

    @field:Json(name = "Label")
    val label: String?,

    @field:Json(name = "Country")
    val country: String?,

    @field:Json(name = "County")
    val county: String?,

    @field:Json(name = "City")
    val city: String?,

    @field:Json(name = "District")
    val district: String?,

    @field:Json(name = "Street")
    val street: String?,

    @field:Json(name = "HouseNumber")
    val houseNumber: String?,

    @field:Json(name = "PostalCode")
    val postalCode: String?

)