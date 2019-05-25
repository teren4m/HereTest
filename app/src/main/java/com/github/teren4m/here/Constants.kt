package com.github.teren4m.here

object Constants {

    const val GPS_INTERVAL: Long = 60000
    val TYPES = listOf(
        "accommodation",
        "administrative-areas-buildings",
        "airport",
        "atm-bank-exchange",
        "coffee-tea",
        "eat-drink",
        "going-out",
        "hospital-health-care-facility",
        "leisure-outdoor",
        "natural-geographical",
        "petrol-station",
        "restaurant",
        "snacks-fast-food",
        "sights-museums",
        "shopping",
        "toilet-rest-area",
        "transport"
    )

    object Address {
        const val RADIUS = 250
        const val MAX_COUNT = 1
    }

    object Map {
        const val DEFAULT_ZOOM = 12.0F
        const val PLACE_ZOOM = 14.0F
    }

}