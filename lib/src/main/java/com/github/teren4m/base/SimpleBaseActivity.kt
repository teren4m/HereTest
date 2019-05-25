package com.github.teren4m.base

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class SimpleBaseActivity : Activity(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        if (savedInstanceState == null) {
            onSetupFragments()
        }
    }

    open fun onSetupFragments() {

    }

    override fun supportFragmentInjector() = fragmentInjector
}