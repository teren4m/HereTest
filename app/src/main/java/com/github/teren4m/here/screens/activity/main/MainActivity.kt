package com.github.teren4m.here.screens.activity.main

import android.os.Bundle
import com.github.teren4m.base.BaseActivity
import com.github.teren4m.here.R
import com.github.teren4m.here.screens.IFragmentNavigation
import javax.inject.Inject

class MainActivity : BaseActivity() {

    override val toolbarId = R.id.toolbar

    override val layoutId = R.layout.activity_main

    @Inject
    lateinit var fragmentNavigation: IFragmentNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragmentNavigation.openSearch()

    }

}