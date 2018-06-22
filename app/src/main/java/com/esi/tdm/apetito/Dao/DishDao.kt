package com.esi.tdm.apetito.Dao

import android.arch.persistence.room.*
import com.esi.tdm.apetito.Entity.CartItem
import com.esi.tdm.apetito.Entity.Dish

@Dao
interface DishDao {

    @Query("select * from dishes")
    fun getDishes():List<Dish>


    @Query("select * from dishes where dish_id=:idDish")
    fun getDishById(idDish:Int): Dish

    @Insert
    fun addDish(vararg dish: Dish)

    @Update
    fun updateDish(dish: Dish)

    @Delete
    fun deleteDish(dish: Dish)


}