package com.esi.tdm.apetito.retrofit

import com.esi.tdm.apetito.Entity.Dish
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DishEndpoint {



    @GET("Dish/{id}")
    fun getDish(@Path("id") id: Int):Call<Dish>

    @GET("Dish")
    fun getDishes():Call<List<Dish>>
//
//    @GET("Dish?query={ \"$\"+\"and\" : [{\"idCategory\": {idCategory}}, {\"idRestaurant\": {idRestaurant} }] }")
//    fun getDishesByCategoryAndRestaurant(@Path("idCategory") idCategory : Int,@Path("idRestaurant") idRestaurant : Int ):Call<List<Dish>>
//
//    @GET("Dish?query={\"idRestaurant\": {idRestaurant} }")
//    fun getDishesByRestaurant(@Path("idRestaurant") idRestaurant : Int):Call<List<Dish>>
//
//    @GET("Dish?query={\"idBinary\": {idBinary} }")
//    fun getDishesByBinary(@Path("idRestaurant") idRestaurant : Int):Call<List<Dish>>

}