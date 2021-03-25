package com.mason.lib.common.base.data.source.http

import com.imyyq.mvvm.http.HttpRequest
import com.mason.lib.common.base.data.source.http.service.CSMAApiService
import com.mason.lib.common.base.entity.BaseEntity
import com.mason.lib.common.base.entity.FriendWebSiteEntity
import com.mason.lib.common.base.source.HttpDataSource

object HttpDataSourceImpl : HttpDataSource {

    private var apiService = HttpRequest.getService(CSMAApiService::class.java)

    override suspend fun login(userName: String, pwd: String): BaseEntity<List<FriendWebSiteEntity?>?>? {
        return apiService.login(userName, pwd)
    }

}