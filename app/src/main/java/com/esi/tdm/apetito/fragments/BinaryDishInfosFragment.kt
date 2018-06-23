package com.esi.tdm.apetito.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.adapters.BinaryAdapter
import com.esi.tdm.apetito.adapters.DishesAdapter
import com.esi.tdm.apetito.models.CartItem
import com.esi.tdm.apetito.models.CartItems
import com.esi.tdm.apetito.models.Dish
import com.esi.tdm.apetito.utlis.Utils
import org.jetbrains.anko.image
import org.jetbrains.anko.support.v4.toast


/**
 * A simple [Fragment] subclass.
 */
class BinaryDishInfosFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view =  inflater!!.inflate(R.layout.fragment_binary_dish_infos, container, false)
        var addToCart = view.findViewById<Button>(R.id.addToCart) as Button
        var dishName = view.findViewById<TextView>(R.id.dishName1a) as TextView
        var dishImage = view.findViewById<ImageView>(R.id.dishImageList1a) as ImageView

        var dishName1 = view.findViewById<TextView>(R.id.dishName2a) as TextView
        var dishImage1 = view.findViewById<ImageView>(R.id.dishImageList2a) as ImageView
        var utils = Utils()
        addToCart.setOnClickListener(View.OnClickListener {
            CartItems.list.add(CartItem(dishName.text.toString(),1,99F,dishImage.drawable))
            CartItems.list.add(CartItem(dishName1.text.toString(),1,7F,dishImage1.drawable))

            toast("Produit ajoutee au panier")
        })
        return view
    }

}// Required empty public constructor
