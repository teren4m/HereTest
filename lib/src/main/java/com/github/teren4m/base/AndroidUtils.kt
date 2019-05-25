package com.github.teren4m.base

import android.app.Activity
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection

fun Activity.inject() {
    AndroidInjection.inject(this)
}

fun Fragment.inject() {
    AndroidSupportInjection.inject(this)
}