package com.github.teren4m.here.screens.places

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.teren4m.adapter.delegate.CompositeDelegateAdapter
import com.github.teren4m.base.mvvm.MvvmFragment
import com.github.teren4m.base.observe
import com.github.teren4m.here.R
import com.github.teren4m.here.screens.map.MapFragment
import kotlinx.android.synthetic.main.fragment_places.*
import javax.inject.Inject

class PlacesFragment : MvvmFragment<IPlacesViewModel>() {

    companion object {
        const val KEY_LOCATION = "key_location"
        const val KEY_TYPES = "key_types"
    }

    override val layoutId = R.layout.fragment_places

    @Inject
    lateinit var adapter: CompositeDelegateAdapter

    @Inject
    lateinit var mapViewModel: IMapViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as MapFragment

        view_list.layoutManager = LinearLayoutManager(context)
        view_list.adapter = adapter

        viewModel.currentLocation.observe(this, mapFragment::currentLocation::set)

        viewModel.places.observe(this) {
            adapter.set(it)
            mapFragment.places = it.map {
                it.position
            }
        }

        viewModel.progress.observe(this) {
            view_progress.isVisible = it
            map_container.isVisible = !it
        }

        mapViewModel.destinationPlace.observe(this, mapFragment::moveToPlace)

    }

}