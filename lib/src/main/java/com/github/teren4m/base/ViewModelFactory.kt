package com.github.teren4m.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val f: () -> ViewModel) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return f().let { it as T }.apply {
            if (!modelClass.isAssignableFrom(this::class.java)) {
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }
}