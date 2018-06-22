package com.esi.tdm.apetito.Dao

import android.arch.persistence.room.*
import com.esi.tdm.apetito.Entity.CartItem
import com.esi.tdm.apetito.Entity.Category

@Dao
interface CategoryDao {

    @Query("select * from categories")
    fun getCategories():List<Category>


    @Query("select * from categories where category_id=:idCategory")
    fun getCategoryById(idCategory:Int): Category

    @Insert
    fun addCategory(vararg category: Category)

    @Update
    fun updateCategory(category: Category)

    @Delete
    fun deleteCategory(category: Category)


}