package com.esi.tdm.apetito.Dao

import android.arch.persistence.room.*
import com.esi.tdm.apetito.Entity.CartItem
import com.esi.tdm.apetito.Entity.Category

@Dao
interface CategoryDao {

    @Query("select * from categories")
    fun getCategories():List<Category>


    @Query("select * from categories where _id=:idCategory")
    fun getCategoryById(idCategory:String): Category

    @Insert
    fun addCategory(vararg category: Category)

    @Insert
    fun addCategories( categories: List<Category>)

    @Update
    fun updateCategory(category: Category)

    @Delete
    fun deleteCategory(category: Category)


}