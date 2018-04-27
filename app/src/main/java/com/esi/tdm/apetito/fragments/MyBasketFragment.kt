package com.esi.tdm.apetito.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView

import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.adapters.CartAdapter
import com.esi.tdm.apetito.utlis.Utils


/**
 * A simple [Fragment] subclass.
 */
class MyBasketFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view =  inflater!!.inflate(R.layout.fragment_my_basket, container, false)
        var list = view.findViewById<ListView>(R.id.CartItems) as ListView
        var utils = Utils()
        var adapter = CartAdapter(activity,utils.populateCart(10))
        list.adapter = adapter
        return view
    }

}// Required empty public constructor
