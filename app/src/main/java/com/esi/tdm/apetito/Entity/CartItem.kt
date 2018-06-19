package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import android.graphics.drawable.Drawable


@Entity(tableName = "cart_items",
        foreignKeys = arrayOf(
                ForeignKey(entity = Dish::class,
                        parentColumns = arrayOf("id"),
                        childColumns = arrayOf("dish_id"),
                        onDelete = ForeignKey.CASCADE)
        )
)
data class CartItem(
                    var dishName:String="",
                    @ColumnInfo(name = "dish_id")
                    var dish1:Long,
                    var quantity:Int=0,
                    var totalPrice:Float=0.0F,
                    var dishImage:Drawable?) {
    @PrimaryKey(autoGenerate = true) var id: Long? = null
}