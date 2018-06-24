package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import android.graphics.drawable.Drawable
import android.support.annotation.Nullable
import java.io.Serializable


@Entity(tableName = "cart_items",
        foreignKeys = arrayOf(
                ForeignKey(entity = Dish::class,
                        parentColumns = arrayOf("_id"),
                        childColumns = arrayOf("_id"),
                        onDelete = ForeignKey.CASCADE)
        )
)
data class CartItem(@PrimaryKey
                    @ColumnInfo(name="_id")
                    var _id:String,
                    @Nullable
                    var dishName:String="",
                    @ColumnInfo(name = "dish_id")
                    @Nullable
                    var idDish:String?="",
                    @Nullable
                    var quantity:Int=0,
                    @Nullable
                    var totalPrice:Float=0.0F,
                    @Nullable
                    var dishImage:String?=""):Serializable