package com.esi.tdm.apetito.retrofit

import com.esi.tdm.apetito.Entity.Reservation
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path



interface ReservationEndpoint {

    @GET("Reservation/{id}")
    fun getReservation(@Path("id") id: Long):Call<Reservation>

    @GET("Reservation")
    fun getReservation():Call<List<Reservation>>


    @POST("Reservation")
    fun addReservation(@Body reservation : Reservation): Call<Reservation>

}