package com.esi.tdm.apetito.retrofit

import com.esi.tdm.apetito.Entity.Dish
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DishEndpoint {

    @GET("Dish/{id}")
    fun getDish(@Path("id") id: String):Call<Dish>

    @GET("Dish")
    fun getDishes():Call<List<Dish>>

}