package com.github.teren4m.here.screens

import android.location.Location

interface IFragmentNavigation {

    fun openPlaces(location: Location, types: Array<String>)

    fun openSearch()

}