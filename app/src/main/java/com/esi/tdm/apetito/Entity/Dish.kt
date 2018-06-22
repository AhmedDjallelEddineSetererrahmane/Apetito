package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "dishes")
data class Dish(@PrimaryKey
                @ColumnInfo(name="dish_id")
                var idDish:Int,
                var name: String = "",
                var description: String = "",
                var price: Float = 0F,
                var listImage:Int=0):Serializable