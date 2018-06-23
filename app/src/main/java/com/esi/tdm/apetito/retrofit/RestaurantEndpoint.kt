package com.esi.tdm.apetito.retrofit

import com.esi.tdm.apetito.Entity.Restaurant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RestaurantEndpoint {

    @GET("Restaurant/{id}")
    fun getRestaurant(@Path("id") id: Int):Call<Restaurant>

    @GET("Restaurant")
    fun getRestaurants():Call<List<Restaurant>>

}