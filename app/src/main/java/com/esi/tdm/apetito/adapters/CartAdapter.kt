package com.esi.tdm.apetito.adapters

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.models.CartItem
import com.esi.tdm.apetito.models.Category

/**
 * Created by djall on 4/25/2018.
 */
class CartAdapter(_ctx: Context, _cartItems:List<CartItem>): BaseAdapter() {
    var ctx = _ctx
    var cartItems = _cartItems


    override fun getItem(p0: Int) = cartItems.get(p0)

    override fun getItemId(p0: Int) = cartItems.get(p0).hashCode().toLong()

    override fun getCount(): Int = cartItems.size

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = p1
        var viewHolder: CartAdapter.ViewHolder

        if(view==null){
            view = LayoutInflater.from(ctx).inflate(R.layout.cart_item_layout,p2,false)
            var image  = view?.findViewById<ImageView>(R.id.itemCartImage) as ImageView
            var name = view?.findViewById<TextView>(R.id.itemCartName) as TextView
            var qty = view?.findViewById<TextView>(R.id.itemCartQty) as TextView
            var totalPrice = view?.findViewById<TextView>(R.id.totalPrice) as TextView

            viewHolder = CartAdapter.ViewHolder(image, name,qty,totalPrice)
            view.setTag(viewHolder)
        }else{
            viewHolder = view.getTag() as CartAdapter.ViewHolder
        }

        var bitmap = BitmapFactory.decodeResource(ctx.resources, cartItems.get(p0).dishImage)
        var round = RoundedBitmapDrawableFactory.create(ctx.resources,bitmap)
        round.cornerRadius = 3F
        //viewHolder.image.setImageResource(restosList.get(p0).listImage)
        viewHolder.image.setImageDrawable(round)
        viewHolder.image.clipToOutline = true
        viewHolder.name.setText(cartItems.get(p0).dishName)
        viewHolder.qty.setText("Quanity : "+cartItems.get(p0).quantity.toString())
        viewHolder.totalPrice.setText(cartItems.get(p0).totalPrice.toString())

        return view
    }

    private data class ViewHolder(var image: ImageView, var name: TextView,var qty:TextView,var totalPrice:TextView)

}