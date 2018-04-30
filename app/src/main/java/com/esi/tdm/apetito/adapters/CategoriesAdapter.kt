package com.esi.tdm.apetito.adapters

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.models.Category
import com.esi.tdm.apetito.models.Restaurant

/**
 * Created by djall on 4/25/2018.
 */
class CategoriesAdapter(_ctx: Context, _categoriesList:List<Category>):BaseAdapter() {
    var ctx = _ctx
    var categoriesList = _categoriesList


    override fun getItem(p0: Int) = categoriesList.get(p0)

    override fun getItemId(p0: Int) = categoriesList.get(p0).hashCode().toLong()

    override fun getCount(): Int = categoriesList.size

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = p1
        var viewHolder: CategoriesAdapter.ViewHolder

        if(view==null){
            view = LayoutInflater.from(ctx).inflate(R.layout.categorie_item_layout,p2,false)
            var image  = view?.findViewById<ImageView>(R.id.categoryImage) as ImageView
            var name = view?.findViewById<TextView>(R.id.categoryName) as TextView
            var fav = view?.findViewById<ImageView>(R.id.fav) as ImageView
            viewHolder = CategoriesAdapter.ViewHolder(image, name,fav)
            view.setTag(viewHolder)
        }else{
            viewHolder = view.getTag() as CategoriesAdapter.ViewHolder
        }

        var bitmap = BitmapFactory.decodeResource(ctx.resources, categoriesList.get(p0).detailImage)
        var round = RoundedBitmapDrawableFactory.create(ctx.resources,bitmap)
        round.cornerRadius = 3F
        //viewHolder.image.setImageResource(restosList.get(p0).listImage)
        viewHolder.image.setImageDrawable(round)
        viewHolder.image.clipToOutline = true
        viewHolder.name.setText(categoriesList.get(p0).name)

        if (categoriesList.get(p0).name=="Plats Vegetariens" || categoriesList.get(p0).name=="Plats Diabetiques"){
            viewHolder.fav.setImageResource(R.drawable.ic_favorite_black_24dp)
        }
        else{
            Log.e("h","hj")
        }

        return view
    }

    private data class ViewHolder(var image: ImageView, var name: TextView,var fav:ImageView)

}