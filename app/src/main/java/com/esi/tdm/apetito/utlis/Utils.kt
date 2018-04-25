package com.esi.tdm.apetito.utlis

import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.models.Dish
import com.esi.tdm.apetito.models.Position
import com.esi.tdm.apetito.models.Restaurant

/**
 * Created by djall on 4/23/2018.
 */
class Utils {

    fun populateRestosData(i:Int):List<Restaurant>{
        var list = mutableListOf<Restaurant>()
        var image = R.drawable.ic_listimage
        var dishes = arrayOf(Dish("plat1","plat1",89F))
        for (j in 0..i) list.add(Restaurant("Resto","ESI-OUEDSMAR", Position(5.5,5.5),"11:00am","11:00pm",4F,dishes ,image,"",""))
        return list
    }
}