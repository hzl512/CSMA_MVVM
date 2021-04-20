package com.mason.csma.category.frags

import androidx.lifecycle.Observer
import com.imyyq.mvvm.base.DataBindingBaseFragment
import com.mason.csma.category.R
import com.mason.csma.category.databinding.FragmentCategoryBinding
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : DataBindingBaseFragment<FragmentCategoryBinding,CategoryViewModel>(R.layout.fragment_category) {

    /**
     * 初始化的第二个方法
     *
     * 这个方法是用来绑定 vm 中的响应式变量到界面中的，通常是 LiveData，事件监听等。
     *
     * 此时 mViewModel 和 mBinding 已实例化。
     */
    override fun initViewObservable() {
        // mBinding 是 layout 文件的绑定类，包含了声明了 id 的所有 view 的引用。这里就是对应 R.layout.activity_main
        // mViewModel 是界面关联的主 VM 的实例，由继承 DataBindingBaseActivity 时的泛型参数决定，这里是 MainViewModel。
//        mViewModel.liveData.observe(viewLifecycleOwner, Observer {
//            text_category.text = it.toString()
//        })
    }

}