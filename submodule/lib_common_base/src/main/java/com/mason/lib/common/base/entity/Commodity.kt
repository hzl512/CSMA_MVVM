package com.mason.lib.common.base.entity

/**
 * @author MasonHuang
 * @date 2021/3/25
 * Desc:
 */
data class Commodity(
    val commodityAddTime: String,
    val commodityAddress: String,
    val commodityBargain: Int,
    val commodityDetail: String,
    val commodityImageUrl: String,
    val commodityName: String,
    val commodityPhone: Int,
    val commodityPrice: String,
    val commodityQQ: Int,
    val commodityViews: Int,
    val id: Int,
    val usersDetail: String,
    val usersID: Int,
    val usersProfessionNameGrade: String
)

