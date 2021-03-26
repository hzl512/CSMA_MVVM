package com.mason.lib.common.base.entity

/**
 * @author MasonHuang
 * @date 2021/3/26
 * Desc: 求购列表
 */
data class Buys(
    val buysAddTime: String,
    val buysAddress: String,
    val buysDetail: String,
    val buysName: String,
    val buysPhone: String,
    val buysPrice: String,
    val buysQQ: Int,
    val buysStatus: Int,
    val id: Int,
    val usersID: Int
)