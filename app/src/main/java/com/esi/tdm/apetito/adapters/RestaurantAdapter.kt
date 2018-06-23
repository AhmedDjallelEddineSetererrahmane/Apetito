package com.esi.tdm.apetito.adapters

import android.content.Context
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.config.baseUrl
import com.esi.tdm.apetito.models.Restaurant
import org.w3c.dom.Text

/**
 * Created by djall on 4/23/2018.
 */
class RestaurantAdapter(_ctx:Context,_restosList:List<Restaurant>):BaseAdapter() {

    var ctx = _ctx
    var restosList = _restosList


    override fun getItem(p0: Int) = restosList.get(p0)

    override fun getItemId(p0: Int) = restosList.get(p0).hashCode().toLong()

    override fun getCount(): Int = restosList.size
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = p1
        var viewHolder:ViewHolder

        if(view==null){
            view = LayoutInflater.from(ctx).inflate(R.layout.restaurant_layout,p2,false)
            var image  = view?.findViewById<ImageView>(R.id.restaurantImage) as ImageView
            var name = view?.findViewById<TextView>(R.id.restaurantName) as TextView
            var adr = view?.findViewById<TextView>(R.id.restaurantAdr) as TextView
            var opening = view?.findViewById<TextView>(R.id.restaurantOpening) as TextView
            var rating = view?.findViewById<TextView>(R.id.rating) as TextView
            viewHolder = ViewHolder(image,name,adr,opening,rating)
            view.setTag(viewHolder)
        }else{
            viewHolder = view.getTag() as ViewHolder
        }

        var bitmap = BitmapFactory.decodeResource(ctx.resources,restosList.get(p0).listImage)
        var round = RoundedBitmapDrawableFactory.create(ctx.resources,bitmap)
        round.cornerRadius = 7.5F
//        Glide.with(ctx).load(baseUrl + restosList.get(p0).listImage)
//
//                .into(viewHolder.image)

        viewHolder.image.setImageResource(restosList.get(p0).listImage)
        viewHolder.image.setImageDrawable(round)
        viewHolder.image.clipToOutline = true
        viewHolder.name.setText(restosList.get(p0).name)
        viewHolder.adr.setText(restosList.get(p0).adr)
        viewHolder.opening.setText(restosList.get(p0).openingHour + " - " + restosList.get(p0).ClosingHour)
        viewHolder.rating.setText(restosList.get(p0).rating.toString())
        return view
    }

    private data class ViewHolder(var image:ImageView,var name:TextView,var adr :TextView,var opening:TextView,var rating:TextView)
}