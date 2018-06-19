package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "reservations")
data class Reservation(
                       var peopleNB:Int=0,
                       var date:String="",
                       var hour:String="") {
    @PrimaryKey(autoGenerate = true) var id: Long? = null
}