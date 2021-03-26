package com.mason.lib.common.base.data.source.http.service

import com.mason.lib.common.base.entity.BaseEntity
import com.mason.lib.common.base.entity.Category
import com.mason.lib.common.base.entity.Commodity
import com.mason.lib.common.base.entity.User
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CSMAApiService {

    @GET("friend/json")
    suspend fun login(
        @Query("userName") userName: String,
        @Query("pwd") pwd: String
    ): BaseEntity<List<User?>?>?

    @POST("CommodityServlet?action=4")
    suspend fun commodityServlet(@Body requestBody: RequestBody): BaseEntity<List<Commodity?>?>?

    @POST("CategoryServlet?action=4")
    suspend fun categoryServlet(@Body requestBody: RequestBody): BaseEntity<List<Category?>?>?

}