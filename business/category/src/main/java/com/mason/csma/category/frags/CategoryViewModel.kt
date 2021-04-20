package com.mason.csma.category.frags

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import android.util.Pair
import androidx.databinding.ObservableArrayList
import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.MapUtils
import com.imyyq.mvvm.base.BaseViewModel
import com.imyyq.mvvm.binding.command.BindingConsumer
import com.imyyq.mvvm.utils.LogUtil
import com.mason.csma.category.R
import com.mason.lib.common.base.data.Repository
import com.scwang.smart.refresh.layout.api.RefreshLayout
import kotlinx.coroutines.delay
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass
import okhttp3.MediaType
import okhttp3.RequestBody
import com.mason.csma.category.BR
import me.tatarka.bindingcollectionadapter2.map

class CategoryViewModel (app: Application) : BaseViewModel<Repository>(app) {

//    val liveData = MutableLiveData<List<Category?>>()
    val observableList = ObservableArrayList<Any>()

    var no = 1
    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        // 使用 vm 的协程，可以在界面销毁时自动取消该协程
        showLoadingDialog()
        no = 1
        onRefresh(no, null)
    }

    val onRefresh = BindingConsumer<RefreshLayout> {
        observableList.clear()
        LogUtil.e("SmartRefresh", "onRefresh")
        no = 1
        onRefresh(no, it)
        it.finishRefresh(1000)
    }

    val onLoadMore = BindingConsumer<RefreshLayout> {
        LogUtil.e("SmartRefresh", "onLoadMore")
        no++
        onRefresh(no, it)
    }

    fun onRefresh(no: Int, refreshLayout: RefreshLayout?) {
        launch({
            if (refreshLayout == null) {
                delay(2000)
            }
            mModel.categoryServlet(
                RequestBody.create(
                    MediaType.parse("application/json"),
                    GsonUtils.toJson(
                        MapUtils.newHashMap(
                            Pair("paging", "true"),
                            Pair("page_no", no.toString()),
                            Pair("page_size", "6")
                        )
                    )
                )
            )
        },
            onSuccess = {
                LogUtil.i("NetworkViewModel", "commonLog - onResume: success")
            },
            onResult = {
                LogUtil.i("NetworkViewModel", "commonLog - onResult: ${it.size}")
//                liveData.value = it
                for (c in it) {
                    observableList.add(RvItemViewModel(this, c!!))
                }
                if (no > 1 && it.size < 6) {
                    refreshLayout?.setNoMoreData(true)
                }else{
                    refreshLayout?.finishLoadMore()
                }
            },
            onFailed = { code, msg ->
                LogUtil.i("NetworkViewModel", "commonLog - onFailed: $code, $msg")
            },
            onComplete = {
                dismissLoadingDialog()
            }
        )
    }

    val multipleItems = OnItemBindClass<Any>().apply {
        map<RvItemViewModel>(BR.viewModel, R.layout.category_list_item_category)
    }

}