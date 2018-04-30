package com.esi.tdm.apetito.models

/**
 * Created by djall on 4/29/2018.
 */
data class Binary(var name:String="",
                  var price:Float=0F,
                  var dish1:Dish,
                  var dish2:Dish) {
}