package com.github.teren4m.here.screens.search.item

import javax.inject.Inject

class ItemsConverter @Inject constructor() {

    fun convert(type: String): TypeItem =
        TypeItem(
            type = type,
            isChecked = false
        )
}