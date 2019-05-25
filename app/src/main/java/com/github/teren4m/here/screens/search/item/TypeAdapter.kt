package com.github.teren4m.here.screens.search.item

import com.github.teren4m.adapter.delegate.DelegateAdapter
import com.github.teren4m.here.R
import kotlinx.android.synthetic.main.item_type.*
import javax.inject.Inject

class TypeAdapter @Inject constructor() : DelegateAdapter<TypeItem>() {

    override val layoutId = R.layout.item_type

    override fun isForViewType(items: List<Any>, position: Int): Boolean =
        items[position] is TypeItem

    override fun onBind(position: Int, item: TypeItem, viewHolder: KViewHolder) {
        viewHolder.run {
            text_type.text = item.type
            view_check_box.isChecked = item.isChecked
            view_check_box.setOnCheckedChangeListener { _, isChecked ->
                item.isChecked = isChecked
            }
        }
    }
}