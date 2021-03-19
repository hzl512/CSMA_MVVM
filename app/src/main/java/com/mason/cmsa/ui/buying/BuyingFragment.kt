package com.mason.cmsa.ui.buying

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mason.cmsa.R

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
        return root
    }
}