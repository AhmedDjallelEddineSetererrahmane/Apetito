package com.esi.tdm.apetito.retrofit

import com.esi.tdm.apetito.Entity.CartItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path



interface CartItemEndpoint {

    @GET("CartItem/{id}")
    fun getCartItem(@Path("id") id: String):Call<CartItem>

    @GET("CartItem")
    fun getCartItem():Call<List<CartItem>>


    @POST("CartItem")
    fun addCartItem(@Body cartItem : CartItem): Call<CartItem>

    @POST("CartItem")
    fun addCartItems(@Body cartItem : List<CartItem>): Call<List<CartItem>>


}