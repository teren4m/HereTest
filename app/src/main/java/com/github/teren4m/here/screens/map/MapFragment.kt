package com.github.teren4m.here.screens.map

import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.view.View
import com.github.teren4m.here.Constants
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : SupportMapFragment(), OnMapReadyCallback {

    var currentLocation: Location? = null
        set(value) {
            field = value
            updateCurrentLocation()
        }

    var places: List<LatLng>? = null
        set(value) {
            field = value
            updatePlaces()
        }

    private var googleMap: GoogleMap? = null
        set(value) {
            field = value
            updateCurrentLocation()
            updatePlaces()
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getMapAsync(this)

    }

    fun moveToPlace(place: LatLng) {
        CameraPosition.Builder()
            .target(place)
            .zoom(Constants.Map.PLACE_ZOOM)
            .build()
            .let(CameraUpdateFactory::newCameraPosition)
            .apply {
                googleMap?.animateCamera(this)
            }
    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap
        googleMap.isMyLocationEnabled = true
        googleMap.uiSettings.apply {
            isZoomControlsEnabled = true
        }
    }

    private fun updateCurrentLocation() {
        if (currentLocation != null && googleMap != null)
            currentLocation?.apply {
                CameraPosition.Builder()
                    .target(LatLng(latitude, longitude))
                    .zoom(Constants.Map.DEFAULT_ZOOM)
                    .build()
                    .let(CameraUpdateFactory::newCameraPosition)
                    .apply {
                        googleMap?.moveCamera(this)
                    }
            }
    }

    private fun updatePlaces() {
        if (currentLocation != null && googleMap != null) {
            places
                ?.forEach {
                    googleMap?.addMarker(
                        MarkerOptions()
                            .position(it)
                    )
                }
        }
    }

}