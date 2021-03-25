package com.mason.lib.common.base.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    var name: String? = null,
    var age: Int? = null,
    var version2: String? = null
)
