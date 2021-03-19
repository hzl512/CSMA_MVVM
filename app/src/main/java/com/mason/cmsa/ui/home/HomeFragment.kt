package com.mason.cmsa.ui.home

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.imyyq.mvvm.utils.ToastUtil
import com.mason.cmsa.R


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        setHasOptionsMenu(true)
        return root
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


}