package com.ferrero.applayduG.db


import androidx.room.Database

import androidx.room.RoomDatabase
import com.ferrero.applayduG.entities.AppsEntity


@Database(entities = arrayOf(AppsEntity::class), version = 1, exportSchema = false)
abstract class UserDB : RoomDatabase() {
    abstract val userDao: Dao
}