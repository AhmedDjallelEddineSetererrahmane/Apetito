package com.esi.tdm.apetito.retrofit

import com.esi.tdm.apetito.config.baseUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    val retrofit = Retrofit.Builder()
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .build();

    val BinaryEndpoint = retrofit.create(BinaryEndpoint::class.java)
    val CartItemEndpoint = retrofit.create(CartItemEndpoint::class.java)
    val CategoryEndpoint = retrofit.create(CategoryEndpoint::class.java)
    val DishEndpoint = retrofit.create(DishEndpoint::class.java)
    val ReservationEndpoint = retrofit.create(ReservationEndpoint::class.java)
    val RestaurantEndpoint = retrofit.create(RestaurantEndpoint::class.java)


}