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
        var lat = _ctx?.resources.getStringArray(R.array.restaurantsLat)
        var lng = _ctx?.resources.getStringArray(R.array.restaurantsLng)
        for (j in 0..images.size-1) list.add(Restaurant(name[j],adr[j], Position(lat[j].toDouble(),lng[j].toDouble()),"11:00am","11:00pm",ratings[j].toFloat() ,images[j],"",""))
        return list
    }

    fun populateCategories(_ctx:Context):List<Category>{
        var list = mutableListOf<Category>()
        var images = arrayOf(R.drawable.ic_salade_cat,R.drawable.ic_plat_cat,R.drawable.ic_drink_cat,R.drawable.ic_dessert_cat,R.drawable.ic_vege_cat,R.drawable.ic_diabetic_cat)
        var names = _ctx?.resources.getStringArray(R.array.categories)
        for (i in 0..images.size-1) list.add(Category(names[i],images[i]))
        return list
    }

    fun populateDishes(_ctx: Context):List<Dish>{
        var list = mutableListOf<Dish>()
        list.addAll(populateDishesEntries(_ctx))
        list.addAll(populateDishesPlats(_ctx))
        list.addAll(populateDishesDesserts(_ctx))
        list.addAll(populateDishesDrinks(_ctx))
        list.addAll(populateDishesVege(_ctx))
        list.addAll(populateDishesDiab(_ctx))
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
        var images = arrayOf(R.drawable.plat1,R.drawable.plat2,R.drawable.plat3,R.drawable.plat4,R.drawable.plat5,R.drawable.plat6)
        var names = _ctx?.resources.getStringArray(R.array.dishName)
        var prices = _ctx?.resources.getStringArray(R.array.dishPrice)
        for(i in 0.. images.size-1) list.add(Dish(names[i],_ctx.resources.getString(R.string.dishDescription),prices[i].toFloat(),images[i]))
        return list
    }

    fun populateDishesDrinks(_ctx:Context):List<Dish>{
        var list = mutableListOf<Dish>()
        var images = arrayOf(R.drawable.drink2,R.drawable.drink3,R.drawable.drink4,R.drawable.drink5,R.drawable.drink6)
        var names = _ctx?.resources.getStringArray(R.array.drinksName)
        var prices = _ctx?.resources.getStringArray(R.array.dishPrice)
        for(i in 0.. images.size-1) list.add(Dish(names[i],_ctx.resources.getString(R.string.dishDescription),prices[i].toFloat(),images[i]))
        return list
    }

    fun populateDishesDesserts(_ctx:Context):List<Dish>{
        var list = mutableListOf<Dish>()
        var images = arrayOf(R.drawable.dessert1,R.drawable.dessert2,R.drawable.dessert3,R.drawable.dessert4,R.drawable.dessert5)
        var names = _ctx?.resources.getStringArray(R.array.dessertsName)
        var prices = _ctx?.resources.getStringArray(R.array.dishPrice)
        for(i in 0.. images.size-1) list.add(Dish(names[i],_ctx.resources.getString(R.string.dishDescription),prices[i].toFloat(),images[i]))
        return list
    }

    fun populateDishesVege(_ctx:Context):List<Dish>{
        var list = mutableListOf<Dish>()
        var images = arrayOf(R.drawable.vege1,R.drawable.vege2,R.drawable.vege3)
        var names = _ctx?.resources.getStringArray(R.array.vegitarianName)
        var prices = _ctx?.resources.getStringArray(R.array.dishPrice)
        for(i in 0.. images.size-1) list.add(Dish(names[i],_ctx.resources.getString(R.string.dishDescription),prices[i].toFloat(),images[i]))
        return list
    }

    fun populateDishesDiab(_ctx:Context):List<Dish>{
        var list = mutableListOf<Dish>()
        var images = arrayOf(R.drawable.diab1,R.drawable.diab2,R.drawable.diab3,R.drawable.diab4)
        var names = _ctx?.resources.getStringArray(R.array.diabetiquesName)
        var prices = _ctx?.resources.getStringArray(R.array.dishPrice)
        for(i in 0.. images.size-1) list.add(Dish(names[i],_ctx.resources.getString(R.string.dishDescription),prices[i].toFloat(),images[i]))
        return list
    }

    fun populateDishesBinary(_ctx: Context):List<Binary>{
        var list = mutableListOf<Binary>()
        var images1 = arrayOf(R.drawable.plat2,R.drawable.plat1,R.drawable.plat3)
        var images2 = arrayOf(R.drawable.dessert1,R.drawable.dessert4,R.drawable.salade4)
        var names1 = arrayOf("plat1","plat2","plat3")
        var names2 = arrayOf("dessert1","dessert2","entree1")
        var name=_ctx?.resources.getStringArray(R.array.Binary)
        var prices = _ctx?.resources.getStringArray(R.array.dishPrice)
        for(i in 0.. images1.size-1) list.add(Binary(name[i],prices[i].toFloat(), Dish(names1[i],_ctx?.resources.getString(R.string.dishDescription),0F,images1[i]),Dish(names2[i],_ctx?.resources.getString(R.string.dishDescription),0F,images2[i])))
        return list
    }

    fun populateCart(i:Int):List<CartItem>{
        return CartItems.list
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