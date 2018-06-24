package com.esi.tdm.apetito.Dao

import android.arch.persistence.room.*
import com.esi.tdm.apetito.Entity.CartItem
import com.esi.tdm.apetito.Entity.Dish
import com.esi.tdm.apetito.Entity.Reservation

@Dao
interface ReservationDao {

    @Query("select * from reservations")
    fun getReservations():List<Reservation>


    @Query("select * from reservations where _id=:idReservation")
    fun getReservationById(idReservation:String): Reservation

    @Insert
    fun addReservation(vararg reservation: Reservation)

    @Insert
    fun addReservations( reservations: List<Reservation>)

    @Update
    fun updateReservation(reservation: Reservation)

    @Delete
    fun deleteReservation(reservation: Reservation)


}