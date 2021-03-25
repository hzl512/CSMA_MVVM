package com.mason.lib.common.base.app

import androidx.lifecycle.MutableLiveData
import com.imyyq.mvvm.base.IAppBarProcessor

class MyCommonAppBarProcessor2 : IAppBarProcessor {
    // 标题
    val title = MutableLiveData<String>("我是默认标题2")
}