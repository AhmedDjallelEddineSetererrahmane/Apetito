package com.esi.tdm.apetito.Dao

import android.arch.persistence.room.*
import com.esi.tdm.apetito.Entity.Restaurant

@Dao
interface RestaurantDao {

    @Query("select * from reservations")
    fun getRestaurants():List<Restaurant>

    @Insert
    fun addRestaurant(vararg restaurant: Restaurant)

    @Update
    fun updateRestaurant(restaurant: Restaurant)

    @Delete
    fun deleteRestaurant(restaurant: Restaurant)


}