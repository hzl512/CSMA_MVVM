package com.imyyq.mvvm.binding.viewadapter.smartrefresh

import androidx.databinding.BindingAdapter
import com.imyyq.mvvm.binding.command.BindingConsumer
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener

/**
 * SmartRefreshLayout 的刷新与载入更多绑定
 */
@BindingAdapter(value = ["onRefresh", "onLoadMore"], requireAll = false)
fun onRefreshLoadMore(
    smartReFreshLayout: SmartRefreshLayout,
    onRefresh: BindingConsumer<RefreshLayout>?,
    onLoadMore: BindingConsumer<RefreshLayout>?
) {
    smartReFreshLayout.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
        override fun onRefresh(refreshLayout: RefreshLayout) {
            onRefresh?.call(refreshLayout)
        }

        override fun onLoadMore(refreshLayout: RefreshLayout) {
            onLoadMore?.call(refreshLayout)
        }

    })
}