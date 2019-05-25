package com.github.teren4m.here.network.model

import com.squareup.moshi.Json

class PlaceItem(

    @field:Json(name = "id")
    val id: String?,

    @field:Json(name = "position")
    val position: Array<Double>?,

    @field:Json(name = "distance")
    val distance: Int?,

    @field:Json(name = "title")
    val title: String?,

    @field:Json(name = "Rating")
    val rating: Int?,

    @field:Json(name = "category")
    val category: Category?,

    @field:Json(name = "icon")
    val icon: String?,

    @field:Json(name = "vicinity")
    val vicinity: String?,

    @field:Json(name = "href")
    val href: String?
)

class Category(

    @field:Json(name = "id")
    val id: String?,

    @field:Json(name = "title")
    val title: String?,

    @field:Json(name = "href")
    val href: String?,

    @field:Json(name = "type")
    val type: String?

)