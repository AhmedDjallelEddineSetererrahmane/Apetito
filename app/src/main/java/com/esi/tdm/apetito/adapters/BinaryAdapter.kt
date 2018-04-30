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
import com.esi.tdm.apetito.models.Binary
import com.esi.tdm.apetito.models.Dish

/**
 * Created by djall on 4/29/2018.
 */
class BinaryAdapter(_ctx: Context, _dishesList:List<Binary>):BaseAdapter() {
    var ctx = _ctx
    var dishesList = _dishesList


    override fun getItem(p0: Int) = dishesList.get(p0)

    override fun getItemId(p0: Int) = dishesList.get(p0).hashCode().toLong()

    override fun getCount(): Int = dishesList.size

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = p1
        var viewHolder: BinaryAdapter.ViewHolder

        if(view==null){
            view = LayoutInflater.from(ctx).inflate(R.layout.binary_layout,p2,false)
            var image1  = view?.findViewById<ImageView>(R.id.dish1ImageList) as ImageView
            var name1 = view?.findViewById<TextView>(R.id.dish1Name) as TextView
            var image2  = view?.findViewById<ImageView>(R.id.dish2ImageList) as ImageView
            var name2 = view?.findViewById<TextView>(R.id.dish2Name) as TextView
            var name = view?.findViewById<TextView>(R.id.binaryName) as TextView
            var price = view?.findViewById<TextView>(R.id.binaryPrice) as TextView
            viewHolder = BinaryAdapter.ViewHolder(image1,name1,image2,name2,name,price)
            view.setTag(viewHolder)
        }else{
            viewHolder = view.getTag() as BinaryAdapter.ViewHolder
        }

        viewHolder.image1.setImageResource(dishesList.get(p0).dish1.listImage)
        viewHolder.name1.setText(dishesList.get(p0).dish1.name)
        viewHolder.image2.setImageResource(dishesList.get(p0).dish2.listImage)
        viewHolder.name2.setText(dishesList.get(p0).dish2.name)
        viewHolder.name.setText(dishesList.get(p0).name)
        viewHolder.price.setText(dishesList.get(p0).price.toString())

        return view
    }

    private data class ViewHolder(var image1: ImageView, var name1: TextView,var image2: ImageView, var name2: TextView,var name: TextView,var price: TextView)
}