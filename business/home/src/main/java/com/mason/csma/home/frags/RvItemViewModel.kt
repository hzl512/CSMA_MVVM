package com.mason.csma.home.frags

import com.imyyq.mvvm.base.MultiItemViewModel
import com.imyyq.mvvm.http.HttpRequest
import com.imyyq.mvvm.utils.LogUtil
import com.mason.lib.common.base.entity.Commodity

/**
 * @author MasonHuang
 * @date 2021/4/19
 * Desc: 首页
 */
class RvItemViewModel(
    viewModel: HomeViewModel,
    val item: Commodity
) :
    MultiItemViewModel<HomeViewModel>(viewModel) {

    val url = HttpRequest.mDefaultBaseUrl + item.commodityImageUrl

}