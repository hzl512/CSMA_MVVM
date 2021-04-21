package com.imyyq.mvvm.binding.viewadapter.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.imyyq.mvvm.binding.command.BindingFunction

/**
 * RecyclerView 分割线
 */
object LineManagers {

    @JvmStatic
    fun both2(space: Int): BindingFunction<RecyclerView, RecyclerView.ItemDecoration> {
        return BindingFunction {
            RecyViewItemDecoration(space, space, space, space)
        }
    }

    @JvmStatic
    fun both(): BindingFunction<RecyclerView, RecyclerView.ItemDecoration> {
        return BindingFunction {
            DividerLine(
                it.context,
                10,
                DividerLine.LINE_BOTH
            )
        }
    }

    @JvmStatic
    fun horizontal(): BindingFunction<RecyclerView, RecyclerView.ItemDecoration> {
        return BindingFunction {
            DividerLine(
                it.context,
                DividerLine.LINE_HORIZONTAL
            )
        }
    }

    @JvmStatic
    fun vertical(): BindingFunction<RecyclerView, RecyclerView.ItemDecoration> {
        return BindingFunction {
            DividerLine(
                it.context,
                DividerLine.LINE_VERTICAL
            )
        }
    }
}