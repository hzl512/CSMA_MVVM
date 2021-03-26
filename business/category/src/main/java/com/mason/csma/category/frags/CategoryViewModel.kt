package com.mason.csma.category.frags

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import android.util.Pair
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.MapUtils
import com.imyyq.mvvm.base.BaseViewModel
import com.imyyq.mvvm.utils.LogUtil
import com.mason.lib.common.base.data.Repository
import com.mason.lib.common.base.entity.Category
import com.mason.lib.common.base.entity.Commodity
import kotlinx.coroutines.delay
import okhttp3.MediaType
import okhttp3.RequestBody

class CategoryViewModel (app: Application) : BaseViewModel<Repository>(app) {

    val liveData = MutableLiveData<List<Category?>>()

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)

        // 使用 vm 的协程，可以在界面销毁时自动取消该协程
        showLoadingDialog()

        launch({
            delay(2000)
            mModel.categoryServlet(
                RequestBody.create(
                    MediaType.parse("application/json"),
                    GsonUtils.toJson(
                        MapUtils.newHashMap(
                            Pair("paging", "true"),
                            Pair("page_no", "1"),
                            Pair("page_size", "10")
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
                liveData.value = it
            },
            onFailed = { code, msg ->
                LogUtil.i("NetworkViewModel", "commonLog - onFailed: $code, $msg")
            },
            onComplete = {
                dismissLoadingDialog()
            }
        )
    }

}