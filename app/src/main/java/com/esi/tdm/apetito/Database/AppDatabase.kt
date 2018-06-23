package com.esi.tdm.apetito.Database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.esi.tdm.apetito.Dao.*

import com.esi.tdm.apetito.Entity.*


@Database(entities = arrayOf(Binary::class,
                             CartItem::class ,
                             Category::class ,
                             Dish::class ,

                             Reservation::class ,
                             Restaurant::class )
         ,version = 1)
abstract class AppDataBase:RoomDatabase() {

    abstract fun getBinaryDao():BinaryDao
    abstract fun getCartItemDao():CartItemDao
    abstract fun getCategoryDao():CategoryDao
    abstract fun getDishDao(): DishDao

    abstract fun getReservationDao(): ReservationDao
    abstract fun getRestaurantDao(): RestaurantDao

}