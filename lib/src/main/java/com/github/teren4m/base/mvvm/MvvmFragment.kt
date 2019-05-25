package com.github.teren4m.base.mvvm

import android.os.Bundle
import android.view.View
import com.github.teren4m.base.inject
import javax.inject.Inject

abstract class MvvmFragment<VM : Any> : BaseFragment() {

    @Inject
    lateinit var viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inject()

        view.setOnTouchListener { _, _ ->
            true
        }
    }
}