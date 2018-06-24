package com.esi.tdm.apetito.Dao

import android.arch.persistence.room.*
import com.esi.tdm.apetito.Entity.CartItem
import com.esi.tdm.apetito.Entity.Restaurant

@Dao
interface RestaurantDao {

    @Query("select * from restaurants")
    fun getRestaurants():List<Restaurant>

    @Query("select * from restaurants where _id=:idRestaurant")
    fun getRestaurantById(idRestaurant:String): Restaurant

    @Insert
    fun addRestaurant( restaurant: Restaurant)


    @Insert
    fun addRestaurants( restaurants: List<Restaurant>)



    @Update
    fun updateRestaurant(restaurant: Restaurant)

    @Delete
    fun deleteRestaurant(restaurant: Restaurant)


}