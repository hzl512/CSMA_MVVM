package com.mason.csma.category.frags

import com.imyyq.mvvm.base.MultiItemViewModel
import com.mason.csma.category.R
import com.mason.lib.common.base.entity.Category


/**
 * @author MasonHuang
 * @date 2021/4/20
 * Desc: 分类的item
 */
class RvItemViewModel(viewModel: CategoryViewModel, val item: Category) :
MultiItemViewModel<CategoryViewModel>(viewModel){

    fun getCategory(): Int {
        when (item.id) {
            1 -> return R.mipmap.category_icon_xydb
            2 -> return R.mipmap.category_icon_sj
            3 -> return R.mipmap.category_icon_dn
            4 -> return R.mipmap.category_icon_smpj
            5 -> return R.mipmap.category_icon_sm
            6 -> return R.mipmap.category_icon_dq
            7 -> return R.mipmap.category_icon_ydjs
            8 -> return R.mipmap.category_icon_yfsm
            9 -> return R.mipmap.category_icon_tsjc
            10 -> return R.mipmap.category_icon_zl
            11 -> return R.mipmap.category_icon_shyl
            12 -> return R.mipmap.category_icon_qt
        }
        return R.mipmap.category_icon_qt
    }

}