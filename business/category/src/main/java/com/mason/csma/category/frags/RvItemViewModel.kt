package com.mason.csma.category.frags

import androidx.lifecycle.ViewModel
import com.imyyq.mvvm.base.MultiItemViewModel
import com.mason.lib.common.base.entity.Category

/**
 * @author MasonHuang
 * @date 2021/4/20
 * Desc: 分类的item
 */
class RvItemViewModel(viewModel: CategoryViewModel, val item: Category) :
MultiItemViewModel<CategoryViewModel>(viewModel){

}