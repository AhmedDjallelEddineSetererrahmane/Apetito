package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.ColorInt



@Entity(tableName = "restaurants",
        foreignKeys = arrayOf(ForeignKey(entity = Position::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("position_id"),
                onDelete = ForeignKey.CASCADE)) )

data class Restaurant(
                      var name: String = "",
                      var adr: String = "",
                      @ColumnInfo(name = "position_id")
                      var position: Long ,
                      @ColumnInfo(name = "opening_hour")
                      var openingHour: String = "",
                      @ColumnInfo(name = "closing_hour")
                      var ClosingHour: String = "",
                      var rating: Float = 0F,
                      var listImage : Int=0,
                      @ColumnInfo(name = "facebook_url")
                      var facebookUrl:String="",
                      @ColumnInfo(name = "twitter_url")
                      var twitterUrl:String=""
) {
    @PrimaryKey(autoGenerate = true) var id: Long?= null
}