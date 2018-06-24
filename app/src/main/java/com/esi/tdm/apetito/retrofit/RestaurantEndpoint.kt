package com.esi.tdm.apetito.retrofit

import com.esi.tdm.apetito.Entity.Restaurant
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RestaurantEndpoint {

    @GET("Restaurant/{id}")
    fun getRestaurant(@Path("id") id: String):Call<Restaurant>

    @GET("Restaurant")
    fun getRestaurants():Call<List<Restaurant>>


    @POST("Restaurant")
    fun addRestaurant(@Body restaurant : Restaurant): Call<Restaurant>

    @POST("Restaurant")
    fun addRestaurants(@Body restaurant : List<Restaurant>): Call<List<Restaurant>>

}