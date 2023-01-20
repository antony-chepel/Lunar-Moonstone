package com.ferrero.applayduG.di

import android.app.Application
import androidx.room.Room
import com.ferrero.applayduG.db.Dao
import com.ferrero.applayduG.db.UserDB
import com.ferrero.applayduG.viewModel.LunarViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val userDB = module {
        fun provideDataBase(application: Application): UserDB {
            return Room.databaseBuilder(application, UserDB::class.java, "USERDB")
                .fallbackToDestructiveMigration()
                .build()
        }

        fun provideDao(dataBase: UserDB): Dao{
            return dataBase.userDao
        }
        single { provideDataBase(androidApplication()) }
        single { provideDao(get()) }

    }
    val  mainViewModel= module{
        viewModel {
            LunarViewModel(get())
        }
    }
