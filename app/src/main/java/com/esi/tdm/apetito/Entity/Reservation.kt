package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "reservations")
data class Reservation(@PrimaryKey
                       @ColumnInfo(name="reservation_id")
                       var idReservation:Int,
                       var peopleNB:Int=0,
                       var date:String="",
                       var hour:String="") :Serializable