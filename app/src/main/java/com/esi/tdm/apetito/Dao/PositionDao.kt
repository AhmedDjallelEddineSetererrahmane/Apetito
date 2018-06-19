package com.esi.tdm.apetito.Dao

import android.arch.persistence.room.*
import com.esi.tdm.apetito.Entity.Position

@Dao
interface PositionDao {

    @Query("select * from positions")
    fun getPositions():List<Position>

    @Insert
    fun addPosition(vararg position: Position)

    @Update
    fun updatePosition(position: Position)

    @Delete
    fun deletePosition(position: Position)


}