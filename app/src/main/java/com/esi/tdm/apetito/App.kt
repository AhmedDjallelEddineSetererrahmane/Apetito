package com.esi.tdm.apetito

import android.app.Application
import com.esi.tdm.apetito.Database.RoomService

class App:Application(){
    override fun onCreate() {
        super.onCreate()
        RoomService.context = applicationContext
    }
}