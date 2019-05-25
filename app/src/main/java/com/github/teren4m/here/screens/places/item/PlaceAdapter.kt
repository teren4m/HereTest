package com.github.teren4m.here.screens.places.item

import com.github.teren4m.adapter.delegate.DelegateAdapter
import com.github.teren4m.here.R
import com.github.teren4m.here.screens.places.IMapViewModel
import kotlinx.android.synthetic.main.item_place.*
import javax.inject.Inject

class PlaceAdapter @Inject constructor(
    private val mapViewModel: IMapViewModel
) : DelegateAdapter<PlaceItem>() {

    override val layoutId = R.layout.item_place

    override fun isForViewType(items: List<Any>, position: Int): Boolean =
        items[position] is PlaceItem

    override fun onBind(position: Int, item: PlaceItem, viewHolder: KViewHolder) {

        viewHolder.run {
            title.text = item.title
            vicinity.text = item.vicinity
            type.text = item.type
            distance.text = "${item.distance}m"

            itemView.setOnClickListener {
                mapViewModel.moveToPlace(item.position)
            }

        }

    }

}