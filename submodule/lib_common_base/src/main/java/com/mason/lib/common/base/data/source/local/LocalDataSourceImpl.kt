package com.mason.lib.common.base.source.local

import com.mason.lib.common.base.source.LocalDataSource

object LocalDataSourceImpl : LocalDataSource {

    override fun saveUserName(userName: String?) {
    }

    override fun savePassword(password: String?) {
    }

    override val userName: String?
        get() = ""
    override val password: String?
        get() = ""

}