package com.esi.tdm.apetito.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.models.CartItem
import com.esi.tdm.apetito.models.CartItems
import kotlinx.android.synthetic.main.fragment_dish_infos.*
import org.jetbrains.anko.db.INTEGER
import org.jetbrains.anko.image
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.support.v4.act
import org.jetbrains.anko.support.v4.toast


/**
 * A simple [Fragment] subclass.
 */
class DishInfosFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view =  inflater!!.inflate(R.layout.fragment_dish_infos, container, false)

        var minus = view.findViewById<TextView>(R.id.minus) as TextView
        var plus = view.findViewById<TextView>(R.id.plus) as TextView
        var dishsNumber = view.findViewById<TextView>(R.id.dishNumber) as TextView
        var addToCart = view.findViewById<Button>(R.id.addToCart) as Button

        var dishName = view.findViewById<TextView>(R.id.dishNameDetail) as TextView
        var dishImage = view.findViewById<ImageView>(R.id.dishImage) as ImageView
        var dishPrice = view.findViewById<TextView>(R.id.dishPriceDetail) as TextView
        minus.setOnClickListener(View.OnClickListener {
            val number = dishsNumber.text.toString().toInt()
            dishsNumber.setText((number-1).toString())
        })
        plus.setOnClickListener(View.OnClickListener {
            val number = dishsNumber.text.toString().toInt()
            dishsNumber.text = (number+1).toString()
        })
        addToCart.setOnClickListener(View.OnClickListener {
            CartItems.list.add(CartItem(dishName.text.toString(),dishsNumber.text.toString().toInt(),(dishsNumber.text.toString().toInt())*(dishPrice.text.toString().toFloat()),dishImage.image))
            toast("Produit ajoutee au panier")
        })
        return view
    }

}// Required empty public constructor
