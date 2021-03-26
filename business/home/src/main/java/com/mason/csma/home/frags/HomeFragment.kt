package com.mason.csma.home.frags

import android.os.Bundle
import android.view.*
import androidx.lifecycle.Observer
import com.imyyq.mvvm.base.DataBindingBaseFragment
import com.imyyq.mvvm.utils.LogUtil
import com.imyyq.mvvm.utils.ToastUtil
import com.kingja.loadsir.callback.Callback
import com.mason.csma.home.R
import com.mason.csma.home.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * 在 xml 中使用 variable 标签声明了 viewModel 变量后，会自动生成 BR.viewModel，
 * https://juejin.cn/post/6857815150565687303/#heading-1
 */
class HomeFragment :
    DataBindingBaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.home, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home_i_want_to_post -> {
                ToastUtil.showShortToast("我要发布")
            }
        }
        return super.onOptionsItemSelected(item)
    }


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
        mViewModel.liveData.observe(viewLifecycleOwner, Observer {
            text_home.text = it.toString()
        })
    }



}

