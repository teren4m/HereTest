package com.github.teren4m.here.utils

import android.widget.ImageView

fun ImageView.uri(uri: String) {
    GlideApp.with(this)
        .load(uri)
        .centerInside()
        .into(this)
}