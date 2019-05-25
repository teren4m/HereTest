package com.github.teren4m.base

import javax.inject.Inject

abstract class BaseViewModelActivity<T : Any> : BaseActivity() {

    @Inject
    lateinit var viewModel: T

}