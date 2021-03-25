package com.mason.lib.common.base.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserDao::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}