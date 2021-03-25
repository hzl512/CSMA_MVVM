package com.mason.lib.common.base.data

import com.imyyq.mvvm.base.BaseModel
import com.mason.lib.common.base.data.source.http.HttpDataSourceImpl
import com.mason.lib.common.base.entity.BaseEntity
import com.mason.lib.common.base.entity.FriendWebSiteEntity
import com.mason.lib.common.base.source.HttpDataSource
import com.mason.lib.common.base.source.LocalDataSource
import com.mason.lib.common.base.source.local.LocalDataSourceImpl

/**
 * 仓库应该是单例的，持有各种数据源
 */
class Repository :
    BaseModel(), HttpDataSource, LocalDataSource {
    private var httpDataSource: HttpDataSource = HttpDataSourceImpl
    private var localDataSource: LocalDataSource = LocalDataSourceImpl

    override suspend fun login(userName: String, pwd: String): BaseEntity<List<FriendWebSiteEntity?>?>? {
        return httpDataSource.login(userName, pwd)
    }

    override fun saveUserName(userName: String?) {
    }

    override fun savePassword(password: String?) {
    }

    override val userName: String?
        get() = ""
    override val password: String?
        get() = ""
}