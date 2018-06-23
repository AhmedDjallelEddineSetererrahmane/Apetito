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
import com.esi.tdm.apetito.models.Dish
import com.esi.tdm.apetito.models.Restaurant

class DishesAdapter(_ctx: Context, _dishesList:List<Dish>):BaseAdapter() {
    var ctx = _ctx
    var dishesList = _dishesList


    override fun getItem(p0: Int) = dishesList.get(p0)

    override fun getItemId(p0: Int) = dishesList.get(p0).hashCode().toLong()

    override fun getCount(): Int = dishesList.size

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = p1
        var viewHolder: DishesAdapter.ViewHolder

        if(view==null){
            view = LayoutInflater.from(ctx).inflate(R.layout.dish_layout,p2,false)
            var image  = view?.findViewById<ImageView>(R.id.dishImageList) as ImageView
            var name = view?.findViewById<TextView>(R.id.dishName) as TextView
            var price = view?.findViewById<TextView>(R.id.dishPrice) as TextView
            viewHolder = DishesAdapter.ViewHolder(image,name,price)
            view.setTag(viewHolder)
        }else{
            viewHolder = view.getTag() as DishesAdapter.ViewHolder
        }

        var bitmap = BitmapFactory.decodeResource(ctx.resources, dishesList.get(p0).listImage)
        var round = RoundedBitmapDrawableFactory.create(ctx.resources,bitmap)
        round.cornerRadius = 3F
        //viewHolder.image.setImageResource(restosList.get(p0).listImage)
        viewHolder.image.setImageDrawable(round)
        viewHolder.image.clipToOutline = true
        viewHolder.name.setText(dishesList.get(p0).name)
        viewHolder.price.setText(dishesList.get(p0).price.toString())

        return view
    }

    private data class ViewHolder(var image: ImageView, var name: TextView,var price: TextView)
}