package com.ferrero.applayduG.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data_save")
data class AppsEntity(
   @PrimaryKey(autoGenerate = true)
   var id : Int? = 0,

   @ColumnInfo(name = "appsCheck")
   var appsCheck: String = "appsChecker",


   )
