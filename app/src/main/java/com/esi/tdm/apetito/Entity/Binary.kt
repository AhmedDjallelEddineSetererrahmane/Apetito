package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "binaries",
        foreignKeys = arrayOf(
                ForeignKey(entity = Dish::class,
                        parentColumns = arrayOf("dish_id"),
                        childColumns = arrayOf("dish1_id"),
                        onDelete = ForeignKey.CASCADE),
                ForeignKey(entity = Dish::class,
                        parentColumns = arrayOf("dish_id"),
                        childColumns = arrayOf("dish2_id"),
                        onDelete = ForeignKey.CASCADE)
                ,
                ForeignKey(entity = Restaurant::class,
                        parentColumns = arrayOf("restaurant_id"),
                        childColumns = arrayOf("restaurant_id"),
                        onDelete = ForeignKey.CASCADE)
        )
)
data class Binary(@PrimaryKey
                  @ColumnInfo(name="binary_id")
                  var idBinary:Int,
                  var name:String="",
                  var price:Float=0F,
                  @ColumnInfo(name = "dish1_id")
                  var dish1:Long,
                  @ColumnInfo(name = "dish2_id")
                  var dish2:Long,
                  @ColumnInfo(name = "restaurant_id")
                  var restaurant: Long) : Serializable