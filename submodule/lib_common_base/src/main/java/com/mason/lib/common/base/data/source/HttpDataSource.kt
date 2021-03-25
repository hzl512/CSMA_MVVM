package com.mason.lib.common.base.source

import com.mason.lib.common.base.entity.BaseEntity
import com.mason.lib.common.base.entity.Commodity
import com.mason.lib.common.base.entity.User
import okhttp3.RequestBody

interface HttpDataSource {

    suspend fun login(userName: String, pwd: String): BaseEntity<List<User?>?>?

    suspend fun commodityServlet(requestBody: RequestBody): BaseEntity<List<Commodity?>?>?

}