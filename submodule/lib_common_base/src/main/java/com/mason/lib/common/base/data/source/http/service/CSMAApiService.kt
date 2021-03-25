package com.mason.lib.common.base.data.source.http.service

import com.mason.lib.common.base.entity.BaseEntity
import com.mason.lib.common.base.entity.FriendWebSiteEntity
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CSMAApiService {

    @GET("friend/json")
    suspend fun login(
        @Query("userName") userName: String,
        @Query("pwd") pwd: String
    ): BaseEntity<List<FriendWebSiteEntity?>?>?

    @GET("https://github.com/")
    fun google(
    ): Call<ResponseBody?>?

}