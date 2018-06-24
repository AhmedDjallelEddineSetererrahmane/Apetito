package com.esi.tdm.apetito.Dao

import android.arch.persistence.room.*
import com.esi.tdm.apetito.Entity.CartItem

@Dao
interface CartItemDao {

    @Query("select * from cart_items")
    fun getCartItems():List<CartItem>

    @Query("select * from cart_items where _id=:idCartItem")
    fun getCartItemById(idCartItem:String): CartItem

    @Insert
    fun addCartItem(vararg cartItem: CartItem)


    @Insert
    fun addCartItems( cartItems: List<CartItem>)

    @Update
    fun updateCartItem(cartItem: CartItem)

    @Delete
    fun deleteCartItem(cartItem: CartItem)


}