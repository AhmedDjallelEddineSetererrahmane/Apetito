package com.esi.tdm.apetito

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.esi.tdm.apetito.Database.AppDataBase
import com.esi.tdm.apetito.Entity.Position
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    var appDataBase: AppDataBase?= null

    @Before
    fun initDB() {
        appDataBase =
                Room.inMemoryDatabaseBuilder(InstrumentationRegistry
                        .getContext(),AppDataBase::class.java).build()
    }

    @After
    fun closeDb(){
        appDataBase?.close()
    }

    @Test
    fun insertAndGetTeam() {
        val position1 = Position(latitude = 2.00 , longitude = 2.00)
        appDataBase?.getPositionDao()?.addPosition(position1)
        val  positions = appDataBase?.getPositionDao()?.getPositions()
        val position2 = positions?.get(0)
        Assert.assertEquals(position1,position2)
    }


}