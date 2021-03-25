package com.mason.lib.common.base.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mason.lib.common.base.entity.User

@Dao
interface UserDao {
    @Insert
    fun insert(list: List<User>)

    @Query("select * from user")
    fun getAllUser(): LiveData<List<User>>
}