package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "binaries",
        foreignKeys = arrayOf(
                ForeignKey(entity = Dish::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("dish1_id"),
                        onDelete = ForeignKey.CASCADE),
                ForeignKey(entity = Dish::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("dish2_id"),
                        onDelete = ForeignKey.CASCADE)
                ,
                ForeignKey(entity = Restaurant::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("restaurant_id"),
                        onDelete = ForeignKey.CASCADE)
        )
)
data class Binary(
                  var name:String="",
                  var price:Float=0F,
                  @ColumnInfo(name = "dish1_id")
                  var dish1:Long,
                  @ColumnInfo(name = "dish2_id")
                  var dish2:Long,
                  @ColumnInfo(name = "restaurant_id")
                  var restaurant: Long) {
    @PrimaryKey(autoGenerate = true) var id: Long? = null
}