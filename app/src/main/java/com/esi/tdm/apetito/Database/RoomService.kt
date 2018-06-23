package com.esi.tdm.apetito.Database

import android.arch.persistence.room.Room
import android.content.Context

object RoomService {


//    lateinit var context : Context
//
//    val appDataBase: AppDataBase by lazy {
//        Room.databaseBuilder(context,AppDataBase::class.java,"dbapetito").allowMainThreadQueries().build()
//    }
    private var INSTANCE: AppDataBase? = null

    fun getInstance(context: Context): AppDataBase? {
        if (INSTANCE == null) {
            synchronized(AppDataBase::class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        AppDataBase::class.java, "bddapetito7.db")
                        .allowMainThreadQueries()
                        .build()
            }
        }
        return INSTANCE
    }

    fun destroyInstance() {
        INSTANCE = null
    }

}


