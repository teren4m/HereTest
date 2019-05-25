package com.github.teren4m.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*
import com.github.teren4m.base.mvvm.BaseViewModel
import io.reactivex.disposables.Disposable

fun <T> LiveData<T>.observe(owner: LifecycleOwner, f: (T) -> Unit) = this.observe(owner, Observer {
    f(it)
})

inline fun <reified T : ViewModel> getViewModel(activity: FragmentActivity, noinline f: () -> ViewModel): T =
    ViewModelFactory(f).let {
        ViewModelProviders.of(activity, it).get(T::class.java)
    }

inline fun <reified T : ViewModel> getViewModel(activity: FragmentActivity): T =
    ViewModelProviders.of(activity).get(T::class.java)

inline fun <reified T : ViewModel> getViewModel(fragment: Fragment, noinline f: () -> ViewModel): T =
    ViewModelFactory(f).let {
        ViewModelProviders.of(fragment, it).get(T::class.java)
    }

inline fun <reified T : ViewModel> getViewModel(fragment: Fragment): T =
    ViewModelProviders.of(fragment).get(T::class.java)