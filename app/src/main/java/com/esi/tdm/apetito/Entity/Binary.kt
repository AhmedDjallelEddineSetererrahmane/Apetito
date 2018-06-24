package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.Nullable
import java.io.Serializable


@Entity(tableName = "binaries",
        foreignKeys = arrayOf(
                ForeignKey(entity = Restaurant::class,
                        parentColumns = arrayOf("_id"),
                        childColumns = arrayOf("_id"),
                        onDelete = ForeignKey.CASCADE)
        )
)
data class Binary(@PrimaryKey
                  @ColumnInfo(name="_id")
                  var _id:String,
                  var name:String="",
                  @Nullable
                  var price:Float=0F,
                  @ColumnInfo(name = "restaurant_id")
                  @Nullable
                  var idRestaurant: String?="") : Serializable