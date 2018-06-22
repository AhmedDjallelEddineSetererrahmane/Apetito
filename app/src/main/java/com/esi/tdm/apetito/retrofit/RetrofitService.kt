package com.esi.tdm.apetito.retrofit

import com.esi.tdm.apetito.config.baseUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
//
//    val retrofit = Retrofit.Builder()
//    .baseUrl(baseUrl)
//    .addConverterFactory(GsonConverterFactory.create())
//    .build();
//
//    val BinaryEndpoint : BinaryEndpoint by lazy {retrofit.create(BinaryEndpoint::class.java)  }
//    val CartItemEndpoint : CartItemEndpoint by lazy {retrofit.create(CartItemEndpoint::class.java)  }
//    val CategoryEndpoint : CategoryEndpoint by lazy {retrofit.create(CategoryEndpoint::class.java)  }
//    val DishEndpoint : DishEndpoint by lazy {retrofit.create(DishEndpoint::class.java)  }
//    val ReservationEndpoint : ReservationEndpoint by lazy {retrofit.create(ReservationEndpoint::class.java)  }
//    val RestaurantEndpoint : RestaurantEndpoint by lazy {retrofit.create(RestaurantEndpoint::class.java)  }
val RestaurantEndpoint: RestaurantEndpoint by lazy {
    Retrofit.Builder().baseUrl(baseUrl).
            addConverterFactory(GsonConverterFactory.create()).build()
            .create(RestaurantEndpoint::class.java)

}

}