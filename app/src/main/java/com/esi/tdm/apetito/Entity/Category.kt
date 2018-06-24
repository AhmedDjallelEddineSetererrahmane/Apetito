package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.Nullable
import java.io.Serializable
@Entity(tableName = "categories")
data class Category(@PrimaryKey
                    @ColumnInfo(name="_id")
                    var _id:String,
                    var name: String="",
                    @Nullable
                    var imageUrl:String?=""
) :Serializable
