package com.esi.tdm.apetito.Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.ColorInt
import android.support.annotation.Nullable
import java.io.Serializable


@Entity(tableName = "restaurants")

data class Restaurant(@PrimaryKey
                      @ColumnInfo(name="_id")
                      var _id:String,
                      var name: String = "",
                      @Nullable
                      var adr: String = "",
                      @ColumnInfo(name = "opening_hour")
                      @Nullable
                      var openingHour: String = "",
                      @ColumnInfo(name = "closing_hour")
                      @Nullable
                      var ClosingHour: String? = "",
                      @Nullable
                      var rating: Float = 0F,
                      @Nullable
                      var imageUrl : String?="" ,
                      @Nullable
                      var imageUrl2 : String?="" ,
                      @Nullable
                      var imageUrl3 : String?="" ,
                      @ColumnInfo(name = "facebook_url")
                      @Nullable
                      var facebookUrl:String?="",
                      @ColumnInfo(name = "twitter_url")
                      @Nullable
                      var twitterUrl:String?="",
                      @Nullable
                      var email:String?="",
                      @Nullable
                      var phone :String?="",
                      @Nullable
                      var description :String?="",
                      @Nullable
                      var latitude: Double = 0.0,
                      @Nullable
                      var longitude: Double = 0.0
) :Serializable