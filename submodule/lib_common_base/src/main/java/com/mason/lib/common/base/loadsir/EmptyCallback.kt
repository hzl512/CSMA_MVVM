package com.mason.lib.common.base.loadsir

import com.kingja.loadsir.callback.Callback
import com.mason.lib.common.base.R

class EmptyCallback: Callback() {
    override fun onCreateView(): Int {
        return R.layout.load_sir_callback_empty
    }
}