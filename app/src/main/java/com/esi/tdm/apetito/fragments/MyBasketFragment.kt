package com.esi.tdm.apetito.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView

import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.activities.OrderActivity
import com.esi.tdm.apetito.adapters.CartAdapter
import com.esi.tdm.apetito.utlis.Utils
import org.jetbrains.anko.support.v4.intentFor


/**
 * A simple [Fragment] subclass.
 */
class MyBasketFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view =  inflater!!.inflate(R.layout.fragment_my_basket, container, false)
        var list = view.findViewById<ListView>(R.id.CartItems) as ListView
        var utils = Utils()
        var adapter = activity?.let { CartAdapter(it,utils.populateCart(10)) }
        list.adapter = adapter
        var orderBtn = view.findViewById<Button>(R.id.orderBtn) as Button
        orderBtn.setOnClickListener(View.OnClickListener {
            startActivity(intentFor<OrderActivity>())
        })
        return view
    }

}// Required empty public constructor
