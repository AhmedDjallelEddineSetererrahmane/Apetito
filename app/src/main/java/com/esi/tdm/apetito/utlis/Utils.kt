package com.esi.tdm.apetito.utlis

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.models.*

/**
 * Created by djall on 4/23/2018.
 */
class Utils {

    fun populateRestosData(_ctx: Context):List<Restaurant>{
        var list = mutableListOf<Restaurant>()
        var images = arrayOf(R.drawable.ic_resto1,R.drawable.ic_resto2,R.drawable.ic_resto3,R.drawable.ic_resto4,R.drawable.ic_resto5)
        var name  = _ctx?.resources.getStringArray(R.array.restaurants)
        var adr =  _ctx?.resources.getStringArray(R.array.restaurantsAdr)
        var ratings =  _ctx?.resources.getStringArray(R.array.restaurantsrating)
        for (j in 0..images.size-1) list.add(Restaurant(name[j],adr[j], Position(5.5,5.5),"11:00am","11:00pm",ratings[j].toFloat() ,images[j],"",""))
        return list
    }

    fun populateCategories(_ctx:Context):List<Category>{
        var list = mutableListOf<Category>()
        var images = arrayOf(R.drawable.ic_salade_cat,R.drawable.ic_plat_cat,R.drawable.ic_drink_cat,R.drawable.ic_dessert_cat,R.drawable.ic_vege_cat,R.drawable.ic_diabetic_cat)
        var names = _ctx?.resources.getStringArray(R.array.categories)
        for (i in 0..images.size-1) list.add(Category(names[i],images[i]))
        return list
    }

    fun populateDishes(i:Int):List<Dish>{
        var list = mutableListOf<Dish>()
        var image = R.drawable.resto_2
        for (j in 0..i) list.add(Dish("Plat ","description1",990F,image))
        return list
    }

    fun populateDishesEntries(_ctx:Context):List<Dish>{
        var list = mutableListOf<Dish>()
        var images = arrayOf(R.drawable.salade1,R.drawable.salade2,R.drawable.salade3,R.drawable.salade4,R.drawable.salade5,R.drawable.salade6)
        var names = _ctx?.resources.getStringArray(R.array.dishEntryName)
        var prices = _ctx?.resources.getStringArray(R.array.dishPrice)
        for(i in 0.. images.size-1) list.add(Dish(names[i],_ctx.resources.getString(R.string.dishDescription),prices[i].toFloat(),images[i]))
        return list
    }
    fun populateDishesPlats(_ctx:Context):List<Dish>{
        var list = mutableListOf<Dish>()
        //var images = arrayOf(R.drawable.plat1,R.drawable.plat2,R.drawable.plat3,R.drawable.plat4,R.drawable.plat5,R.drawable.plat6)
        var names = _ctx?.resources.getStringArray(R.array.dishName)
        var prices = _ctx?.resources.getStringArray(R.array.dishPrice)
        //for(i in 0.. images.size-1) list.add(Dish(names[i],_ctx.resources.getString(R.string.dishDescription),prices[i].toFloat(),images[i]))
        return list
    }

    fun populateCart(i:Int):List<CartItem>{
        var list = mutableListOf<CartItem>()
        var image = R.drawable.ic_listimage
        for (j in 0..i) list.add(CartItem("Plat1",1,1000F,image))
        return list
    }
    fun openFacebookPage(ctx: Context, facebookUrl: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl))
        ctx.startActivity(intent)
    }

    fun openTwitterPage(ctx: Context, twitterUrl: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(twitterUrl))
        ctx.startActivity(intent)
    }
}