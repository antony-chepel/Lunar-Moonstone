package com.ferrero.applayduG.db

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ferrero.applayduG.entities.AppsEntity


@androidx.room.Dao
interface Dao {
    @Query("SELECT * FROM data_save")
    fun getAllData() : LiveData<AppsEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(appsEntity: AppsEntity)
}