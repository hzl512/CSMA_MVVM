package com.mason.csma.buying.frags

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.imyyq.mvvm.utils.ToastUtil
import com.mason.csma.buying.R

class BuyingFragment : Fragment() {

    private lateinit var buyingViewModel: BuyingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        buyingViewModel =
            ViewModelProviders.of(this).get(BuyingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_buying, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        buyingViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        setHasOptionsMenu(true)
        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.buying, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.buying_i_request_to_buy -> {
                ToastUtil.showShortToast("我要求购")
            }
        }
        return super.onOptionsItemSelected(item)
    }

}