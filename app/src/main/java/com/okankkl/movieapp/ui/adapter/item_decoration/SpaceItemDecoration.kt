package com.okankkl.movieapp.ui.adapter.item_decoration

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.okankkl.movieapp.util.LayoutType

class SpaceItemDecoration(
        private var layoutType: LayoutType
    ) : RecyclerView.ItemDecoration()
{
    override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State)
    {
        val resources = view.resources
        outRect.top = getPaddingValue(resources,layoutType.verticalPadding)
        if(layoutType == LayoutType.Grid){
            outRect.left = getPaddingValue(resources,layoutType.horizontalPadding)
        }
        else if(parent.getChildAdapterPosition(view) == 0) {
            outRect.left = getPaddingValue(resources,layoutType.horizontalPadding) * 2
        }
        outRect.left = getPaddingValue(resources,layoutType.horizontalPadding)
    }
}

private fun getPaddingValue(resources: Resources,dimensionId : Int) : Int{
    return resources.getDimension(dimensionId).toInt()
}