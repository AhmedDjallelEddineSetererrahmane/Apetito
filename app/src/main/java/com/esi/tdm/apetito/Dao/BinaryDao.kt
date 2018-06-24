package com.esi.tdm.apetito.Dao

import android.arch.persistence.room.*
import com.esi.tdm.apetito.Entity.Binary

@Dao
interface BinaryDao {

    @Query("select * from binaries")
    fun getBinaries():List<Binary>

    @Query("select * from binaries where _id=:idBinary")
    fun getBinaryById(idBinary:String):Binary

    @Insert
    fun addPlayer(vararg binary: Binary)

    @Insert
    fun addBinaries( binaries: List<Binary>)

    @Update
    fun updatePlayer(binary: Binary)

    @Delete
    fun deletePlayer(binary: Binary)


}