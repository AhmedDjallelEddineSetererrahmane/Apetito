package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.Nullable
import java.io.Serializable


@Entity(tableName = "reservations")
data class Reservation(@PrimaryKey
                       @ColumnInfo(name="_id")
                       var _id:String,
                       @Nullable
                       var peopleNB:Int=0,
                       @Nullable
                       var date:String?="",
                       @Nullable
                       var hour:String?="") :Serializable