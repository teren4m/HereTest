package com.github.teren4m.here.network

import android.util.Log
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.moshi.moshiDeserializerOf
import com.github.kittinunf.fuel.rx.rxResponseObject
import com.github.teren4m.here.network.model.AddressesResponse
import com.github.teren4m.here.network.model.PlacesResponse
import io.reactivex.Single
import javax.inject.Inject

class HereDataSource @Inject constructor() {

    companion object {
        private const val APP_CODE = "9uA1rqjuIyJWN9feeCF4wg"
        private const val APP_ID = "P5ZbY2ME3ZPqbDLpOYM1"
    }

    fun reverseGeocode(lat: Double, lng: Double, radius: Int, maxResults: Int): Single<AddressesResponse> =
        StringBuilder()
            .append("https://reverse.geocoder.api.here.com/6.2/reversegeocode.json")
            .append("?prox=$lat%2C$lng%2C$radius")
            .append("&mode=retrieveAddresses")
            .append("&maxresults=$maxResults")
            .append("&app_id=$APP_ID")
            .append("&app_code=$APP_CODE")
            .toString()
            .rxGet()

    fun explore(lat: Double, lng: Double, types: List<String>): Single<PlacesResponse> =
        StringBuilder()
            .append("https://places.demo.api.here.com/places/v1/discover/explore")
            .append("?at=$lat%2C$lng")
            .apply {
                if(types.isNotEmpty()){
                    this.append("&cat=${types.reduce { acc, s -> "$acc%2C$s" }}")
                }
            }
            .append("&app_id=$APP_ID")
            .append("&app_code=$APP_CODE")
            .toString()
            .rxGet()

    private inline fun <reified T : Any> String.rxGet(): Single<T> =
        this.apply {
            Log.d("Fuel", this)
        }
            .httpGet()
            .rxResponseObject(
                moshiDeserializerOf(
                    T::class.java
                )
            )

}