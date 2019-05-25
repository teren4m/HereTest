package com.github.teren4m.here.screens.places.domain

import com.github.teren4m.here.Constants
import com.github.teren4m.here.data.IPlacesRepository
import com.github.teren4m.here.screens.places.domain.model.Place
import io.reactivex.Observable
import javax.inject.Inject

class PlacesUseCase @Inject constructor(
    private val placesRepository: IPlacesRepository,
    private val converter: PlacesConverter
) : IPlacesUseCase {

    override fun explore(lat: Double, lng: Double, types: List<String>): Observable<Place> =
        placesRepository.explore(lat, lng, types)
            .sorted { o1, o2 ->
                o1.distance - o2.distance
            }
            .map(converter::convert)

    override fun reverseGeocode(lat: Double, lng: Double): Observable<String> =
        placesRepository.reverseGeocode(
            lat, lng,
            Constants.Address.RADIUS,
            Constants.Address.MAX_COUNT
        )
            .map(converter::convert)

}