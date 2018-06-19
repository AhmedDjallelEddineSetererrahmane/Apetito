package com.esi.tdm.apetito.Dao

import android.arch.persistence.room.*
import com.esi.tdm.apetito.Entity.Reservation

@Dao
interface ReservationDao {

    @Query("select * from reservations")
    fun getReservations():List<Reservation>

    @Insert
    fun addReservation(vararg reservation: Reservation)

    @Update
    fun updateReservation(reservation: Reservation)

    @Delete
    fun deleteReservation(reservation: Reservation)


}