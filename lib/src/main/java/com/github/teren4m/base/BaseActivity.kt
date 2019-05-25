package com.github.teren4m.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {

    abstract val toolbarId: Int
    abstract val layoutId: Int

    lateinit var toolbar: Toolbar

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        toolbar = findViewById(toolbarId)
        setSupportActionBar(toolbar)
    }

    override fun supportFragmentInjector() = fragmentInjector
}