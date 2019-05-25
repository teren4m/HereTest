package com.github.teren4m.here.screens

import android.location.Location
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import com.github.teren4m.here.screens.places.PlacesFragment
import com.github.teren4m.here.screens.search.SearchFragment
import javax.inject.Inject

class FragmentNavigation @Inject constructor(
    private val activity: FragmentActivity,
    @IdRes
    private val containerId: Int
) : IFragmentNavigation {

    override fun openSearch() {
        activity.supportFragmentManager
            .beginTransaction()
            .replace(containerId, SearchFragment())
            .commit()
    }

    override fun openPlaces(location: Location, types: Array<String>) {
        activity.supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(containerId, PlacesFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(PlacesFragment.KEY_LOCATION, location)
                    putStringArray(PlacesFragment.KEY_TYPES, types)
                }
            })
            .commit()
    }

}