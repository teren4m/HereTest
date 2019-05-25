package com.github.teren4m.here.screens.places.domain

import com.github.teren4m.here.screens.places.domain.model.Place
import io.reactivex.Observable

interface IPlacesUseCase {

    fun reverseGeocode(lat: Double, lng: Double): Observable<String>

    fun explore(lat: Double, lng: Double, types: List<String>): Observable<Place>

}