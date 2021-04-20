package com.imyyq.mvvm.binding.viewadapter.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.imyyq.mvvm.utils.DensityUtil.dp2px

/**
 * @author MasonHuang
 * @date 2021/4/20
 * Desc: item的间隔
 */
class RecyViewItemDecoration(
    var spaceLeft: Int = 0, var spaceRight: Int = 0,
    var spaceBottom: Int = 0, var spaceTop: Int = 0
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = dp2px(spaceLeft.toFloat())
        outRect.right = dp2px(spaceRight.toFloat())
        outRect.bottom = dp2px(spaceBottom.toFloat())
        outRect.top = dp2px(spaceTop.toFloat())
    }

}