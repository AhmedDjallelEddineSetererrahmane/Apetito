package com.esi.tdm.apetito.Database

import android.arch.persistence.room.Room
import android.content.Context

object RoomService {


    lateinit var context : Context

    val appDataBase: AppDataBase by lazy {
        Room.databaseBuilder(context!!,AppDataBase::class.java,"dbapetito").allowMainThreadQueries().build()
    }

}


