package com.ferrero.applayduG.db

import androidx.room.Insert
import androidx.room.OnConflictStrategy

import com.ferrero.applayduG.entities.AppsEntity


@androidx.room.Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(appsEntity: AppsEntity)
}