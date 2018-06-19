package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "categories")
data class Category(
                    var name: String="",
                    var detailImage:Int=0
) {
    @PrimaryKey(autoGenerate = true) var id: Long?= null
}