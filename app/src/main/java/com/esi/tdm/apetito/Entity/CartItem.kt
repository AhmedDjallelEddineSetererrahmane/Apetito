package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import android.graphics.drawable.Drawable
import java.io.Serializable


@Entity(tableName = "cart_items",
        foreignKeys = arrayOf(
                ForeignKey(entity = Dish::class,
                        parentColumns = arrayOf("dish_id"),
                        childColumns = arrayOf("dish_id"),
                        onDelete = ForeignKey.CASCADE)
        )
)
data class CartItem(@PrimaryKey
                    @ColumnInfo(name="cart_item_id")
                    var idCartItem:Int,
                    var dishName:String="",
                    @ColumnInfo(name = "dish_id")
                    var dish:Long,
                    var quantity:Int=0,
                    var totalPrice:Float=0.0F,
                    var dishImage:String?):Serializable