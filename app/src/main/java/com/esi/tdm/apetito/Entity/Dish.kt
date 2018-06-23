package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "dishes",
        foreignKeys = arrayOf(
                ForeignKey(entity = Restaurant::class,
                        parentColumns = arrayOf("restaurant_id"),
                        childColumns = arrayOf("restaurant_id"),
                        onDelete = ForeignKey.CASCADE) ,
                ForeignKey(entity = Category::class,
                        parentColumns = arrayOf("category_id"),
                        childColumns = arrayOf("category_id"),
                        onDelete = ForeignKey.CASCADE),
                ForeignKey(entity = Binary::class,
                        parentColumns = arrayOf("binary_id"),
                        childColumns = arrayOf("binary_id"),
                        onDelete = ForeignKey.CASCADE)

        )
)

data class Dish(@PrimaryKey
                @ColumnInfo(name="dish_id")
                var idDish:Int,
                var name: String = "",
                var description: String = "",
                var price: Float = 0F,
                var listImage:Int=0 ,
                @ColumnInfo(name = "restaurant_id")
                var idRestaurant:Int=0 ,
                @ColumnInfo(name = "category_id")
                var idCategory:Int=0 ,
                @ColumnInfo(name = "binary_id")
                var idBinary:Int=0 ,
                var imageUrl:String?=""
):Serializable