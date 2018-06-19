package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "dishes")
data class Dish(
                var name: String = "",
                var description: String = "",
                var price: Float = 0F,
                var listImage:Int=0) {
    @PrimaryKey(autoGenerate = true) var id: Long?= null
}