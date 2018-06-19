package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "positions")
class Position(
               var latitude: Double = 0.0,
               var longitude: Double = 0.0) {
    @PrimaryKey(autoGenerate = true) var id: Long? = null
}