package com.mason.lib.common.base.source

import com.mason.lib.common.base.entity.BaseEntity
import com.mason.lib.common.base.entity.FriendWebSiteEntity

interface HttpDataSource {
    // wanandroid 的开发 api 模拟登录 https://www.wanandroid.com/
    suspend fun login(userName: String, pwd: String): BaseEntity<List<FriendWebSiteEntity?>?>?
}