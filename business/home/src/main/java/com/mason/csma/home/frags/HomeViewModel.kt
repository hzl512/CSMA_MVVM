package com.mason.csma.home.frags

import android.app.Application
import android.util.Pair
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.MapUtils
import com.imyyq.mvvm.base.BaseViewModel
import com.imyyq.mvvm.binding.command.BindingConsumer
import com.imyyq.mvvm.utils.LogUtil
import com.mason.csma.home.R
import com.mason.csma.home.BR
import com.mason.lib.common.base.data.Repository
import com.mason.lib.common.base.entity.Buys
import com.mason.lib.common.base.entity.Commodity
import com.scwang.smart.refresh.layout.api.RefreshLayout
import okhttp3.MediaType
import kotlinx.coroutines.delay
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass
import me.tatarka.bindingcollectionadapter2.map

import okhttp3.RequestBody

class HomeViewModel(app: Application) : BaseViewModel<Repository>(app) {

//    val liveData = MutableLiveData<List<Commodity?>>()

    val observableList = ObservableArrayList<Any>()

    var no = 1

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
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
            mModel.commodityServlet(
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
        map<RvItemViewModel>(BR.viewModel, R.layout.home_gird_item_commodity)
    }

}