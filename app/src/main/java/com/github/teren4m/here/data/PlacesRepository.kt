package com.github.teren4m.here.data

import com.github.teren4m.here.data.model.AddressRaw
import com.github.teren4m.here.data.model.PlaceRaw
import com.github.teren4m.here.network.HereDataSource
import com.gojuno.koptional.rxjava2.filterSome
import com.gojuno.koptional.toOptional
import io.reactivex.Observable
import javax.inject.Inject

class PlacesRepository @Inject constructor(
    private val hereDataSource: HereDataSource,
    private val converter: PlacesConverter
) : IPlacesRepository {

    override fun explore(lat: Double, lng: Double, types: List<String>): Observable<PlaceRaw> =
        hereDataSource.explore(lat, lng, types)
            .toObservable()
            .flatMapIterable {
                it.response?.items ?: emptyList()
            }
            .map {
                it.let(converter::convert)
            }

    override fun reverseGeocode(lat: Double, lng: Double, radius: Int, maxResults: Int): Observable<AddressRaw> =
        hereDataSource.reverseGeocode(lat, lng, radius, maxResults)
            .toObservable()
            .flatMapIterable {
                it.response?.views ?: emptyList()
            }
            .flatMapIterable {
                it.result ?: emptyList()
            }
            .map {
                it.location?.address
                    ?.let(converter::convert)
                    .toOptional()
            }
            .filterSome()

}