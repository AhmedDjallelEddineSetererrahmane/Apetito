package com.esi.tdm.apetito.Dao

import android.arch.persistence.room.*
import com.esi.tdm.apetito.Entity.Binary

@Dao
interface BinaryDao {

    @Query("select * from binaries")
    fun getBinaries():List<Binary>

    @Insert
    fun addPlayer(vararg binary: Binary)

    @Update
    fun updatePlayer(binary: Binary)

    @Delete
    fun deletePlayer(binary: Binary)


}