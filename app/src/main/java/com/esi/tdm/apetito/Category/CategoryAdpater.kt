package com.esi.tdm.apetito.Category

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.esi.tdm.apetito.Entity.Category
import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.config.imageBaseUrl
import org.jetbrains.anko.image


class CategoryAdpater(_ctx:Context,_categoriesList:List<Category>):BaseAdapter() {

    var ctx = _ctx
    var categoriesList = _categoriesList


    override fun getItem(p0: Int) = categoriesList.get(p0)

    override fun getItemId(p0: Int) = categoriesList.get(p0).hashCode().toLong()

    override fun getCount(): Int = categoriesList.size
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = p1
        var viewHolder: ViewHolder

        if(view==null){
            view = LayoutInflater.from(ctx).inflate(R.layout.categorie_item_layout,p2,false)
            var image  = view?.findViewById<ImageView>(R.id.categoryImage) as ImageView
            var name = view?.findViewById<TextView>(R.id.categoryName) as TextView
            var fav = view?.findViewById<ImageView>(R.id.fav) as ImageView
            viewHolder = ViewHolder(image, name, fav)
            view.setTag(viewHolder)
        }else{
            viewHolder = view.getTag() as ViewHolder
        }

        Glide.with(ctx).load(imageBaseUrl
                + categoriesList.get(p0).imageUrl)
                .into(viewHolder.image)

        viewHolder.name.setText(categoriesList.get(p0).name)
        viewHolder.fav.setImageResource(R.drawable.ic_favorite_black_24dp)
        return view
    }

    private data class ViewHolder(var image:ImageView,var name:TextView,var fav:ImageView)
}