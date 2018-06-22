package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "positions")
class Position(@PrimaryKey
               @ColumnInfo(name="position_id")
               var idPosition:Int,
               var latitude: Double = 0.0,
               var longitude: Double = 0.0):Serializable