package com.mason.lib.common.base.entity

import com.imyyq.mvvm.base.IBaseResponse

data class BaseEntity<T>(
    var data: T?,
    var errorcode: Int?,
    var errormsg: String?,
    var total: Int?
) : IBaseResponse<T> {
    override fun code() = errorcode

    override fun msg() = errormsg

    override fun data() = data

    override fun isSuccess() = errorcode == 0
}