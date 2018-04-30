package com.esi.tdm.apetito.models

import android.graphics.drawable.Drawable

/**
 * Created by djall on 4/25/2018.
 */
data class CartItem(var dishName:String="",
                    var quantity:Int=0,
                    var totalPrice:Float=0.0F,
                    var dishImage:Drawable?) {
}