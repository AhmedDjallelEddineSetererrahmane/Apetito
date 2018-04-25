package com.esi.tdm.apetito.models

/**
 * Created by djall on 4/23/2018.
 */
data class Restaurant(var name: String = "",
                      var adr: String = "",
                      var geoPosition: Position,
                      var openingHour: String = "",
                      var ClosingHour: String = "",
                      var rating: Float = 0F,
                      var dishes: Array<Dish> = arrayOf<Dish>(),
                      var listImage : Int=0,
                      var facebookUrl:String="",
                      var twitterUrl:String=""
) {
}