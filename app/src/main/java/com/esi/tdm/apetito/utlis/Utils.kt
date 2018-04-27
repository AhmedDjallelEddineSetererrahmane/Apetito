package com.esi.tdm.apetito.utlis

import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.models.*

/**
 * Created by djall on 4/23/2018.
 */
class Utils {

    fun populateRestosData(i:Int):List<Restaurant>{
        var list = mutableListOf<Restaurant>()
        var image = R.drawable.ic_listimage
        for (j in 0..i) list.add(Restaurant("Resto","ESI-OUEDSMAR", Position(5.5,5.5),"11:00am","11:00pm",4F ,image,"",""))
        return list
    }

    fun populateCategories(i:Int):List<Category>{
        var list = mutableListOf<Category>()
        var image = R.drawable.ic_listimage
        var dishes = arrayOf(Dish("Plate 1","Description 1",99F,image),Dish("Plate 1","Description 1",99F,R.drawable.ic_listimage))
        for (j in 0..i) list.add(Category("Categorie",image,dishes))
        return list
    }

    fun populateDishes(i:Int):List<Dish>{
        var list = mutableListOf<Dish>()
        var image = R.drawable.resto_2
        for (j in 0..i) list.add(Dish("Plat ","description1",990F,image))
        return list
    }

    fun populateCart(i:Int):List<CartItem>{
        var list = mutableListOf<CartItem>()
        var image = R.drawable.ic_listimage
        for (j in 0..i) list.add(CartItem("Plat1",1,1000F,image))
        return list
    }
}