package com.mason.lib.common.base.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.imyyq.sample.data.source.local.UserDao

@Database(entities = [UserDao::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}