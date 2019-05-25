package com.github.teren4m.base.mvvm

class ActionLiveEvent : SingleLiveEvent<Unit>() {

    override fun call() {
        value = Unit
    }
}