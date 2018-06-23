package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable
@Entity(tableName = "categories")
data class Category(@PrimaryKey
                    @ColumnInfo(name="category_id")
                    var idCategory:Int,
                    var name: String="",
                    var detailImage:Int=0 ,
                    var imageUrl:String?=""
) :Serializable
