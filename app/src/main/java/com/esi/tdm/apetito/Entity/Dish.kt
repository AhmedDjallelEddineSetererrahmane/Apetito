package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.Nullable
import java.io.Serializable

@Entity(tableName = "dishes")


data class Dish(@PrimaryKey
                @ColumnInfo(name="_id")
                var _id:String,
                var name: String = "",
                @Nullable
                var description: String?="",
                @Nullable
                var price: Float = 0F,
                @ColumnInfo(name = "restaurant_id")
                @Nullable
                var idRestaurant:String?="",
                @ColumnInfo(name = "category_id")
                @Nullable
                var idCategory:String?="",
                @ColumnInfo(name = "binary_id")
                @Nullable
                var idBinary:String?="",
                @Nullable
                var imageUrl:String?="" ,
                @ColumnInfo(name = "in_cart")
                @Nullable
                var inCart:Boolean?=false
):Serializable