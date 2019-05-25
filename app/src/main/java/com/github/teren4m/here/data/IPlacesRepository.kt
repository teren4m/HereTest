package com.github.teren4m.here.data

import com.github.teren4m.here.data.model.AddressRaw
import com.github.teren4m.here.data.model.PlaceRaw
import io.reactivex.Observable

interface IPlacesRepository {

    fun explore(lat: Double, lng: Double, types: List<String>): Observable<PlaceRaw>

    fun reverseGeocode(lat: Double, lng: Double, radius: Int, maxResults: Int): Observable<AddressRaw>

}