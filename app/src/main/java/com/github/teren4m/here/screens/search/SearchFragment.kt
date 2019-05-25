package com.github.teren4m.here.screens.search

import android.Manifest
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.teren4m.adapter.delegate.CompositeDelegateAdapter
import com.github.teren4m.base.mvvm.MvvmFragment
import com.github.teren4m.base.observe
import com.github.teren4m.here.R
import com.github.teren4m.here.screens.IFragmentNavigation
import com.google.android.gms.location.LocationRequest
import com.patloew.rxlocation.RxLocation
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_search.*
import javax.inject.Inject

class SearchFragment : MvvmFragment<ISearchViewModel>() {

    override val layoutId = R.layout.fragment_search

    @Inject
    lateinit var rxPermissions: RxPermissions

    @Inject
    lateinit var rxLocation: RxLocation

    @Inject
    lateinit var locationRequest: LocationRequest

    @Inject
    lateinit var adapter: CompositeDelegateAdapter

    @Inject
    lateinit var fragmentNavigation: IFragmentNavigation

    private lateinit var disposable: Disposable

    @SuppressLint("MissingPermission")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view_list.layoutManager = LinearLayoutManager(context)
        view_list.adapter = adapter

        disposable = rxPermissions
            .request(
                Manifest.permission.ACCESS_FINE_LOCATION
            )
            .flatMap {
                if (it) {
                    rxLocation.location()
                        .updates(locationRequest)
                } else {
                    error("No permission")
                }
            }
            .subscribeBy(
                onNext = viewModel::updateLocation,
                onError = {
                    //TODO show error
                    toString()
                }
            )

        button_search.setOnClickListener {
            viewModel.search()
        }

        viewModel.isSearchAvailable.observe(this, button_search::setEnabled)
        viewModel.address.observe(this, text_address::setText)
        viewModel.types.observe(this, adapter::set)
        viewModel.showPlaces.observe(this) {
            fragmentNavigation.openPlaces(it.location, it.types)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

}