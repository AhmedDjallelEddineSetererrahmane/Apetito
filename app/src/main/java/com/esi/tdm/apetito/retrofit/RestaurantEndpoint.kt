package com.esi.tdm.apetito.retrofit

import com.esi.tdm.apetito.Entity.Restaurant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RestaurantEndpoint {

    @GET("layout/Restaurant/{id}")
    fun getRestaurant(@Path("id") id: String):Call<Restaurant>

    @GET("layout/Restaurant")
    fun getRestaurants():Call<List<Restaurant>>

}