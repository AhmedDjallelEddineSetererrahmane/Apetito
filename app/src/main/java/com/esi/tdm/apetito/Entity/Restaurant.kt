package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.ColorInt
import java.io.Serializable


@Entity(tableName = "restaurants")

data class Restaurant(@PrimaryKey
                      @ColumnInfo(name="restaurant_id")
                      var idRestaurant:Int,
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
                      var imageUrl : String?="" ,
                      var imageUrl2 : String?="" ,
                      var imageUrl3 : String?="" ,
                      @ColumnInfo(name = "facebook_url")
                      var facebookUrl:String="",
                      @ColumnInfo(name = "twitter_url")
                      var twitterUrl:String="",
                      var email:String,
                      var phone :String,
                      var description :String,
                      var latitude: Double = 0.0,
                      var longitude: Double = 0.0
) :Serializable