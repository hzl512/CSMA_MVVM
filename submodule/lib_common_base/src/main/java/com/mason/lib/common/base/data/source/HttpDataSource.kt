package com.mason.lib.common.base.source

import com.mason.lib.common.base.entity.*
import okhttp3.RequestBody

interface HttpDataSource {

    suspend fun login(userName: String, pwd: String): BaseEntity<List<User?>?>?

    suspend fun commodityServlet(requestBody: RequestBody): BaseEntity<List<Commodity?>?>?

    suspend fun categoryServlet(requestBody: RequestBody): BaseEntity<List<Category?>?>?

    suspend fun buysServlet(requestBody: RequestBody): BaseEntity<List<Buys?>?>?

}