package com.esi.tdm.apetito.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView

import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.adapters.BinaryAdapter
import com.esi.tdm.apetito.adapters.DishesAdapter
import com.esi.tdm.apetito.utlis.Utils


/**
 * A simple [Fragment] subclass.
 */
class BinaryFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view =  inflater!!.inflate(R.layout.fragment_binary, container, false)
        var listView = view.findViewById<ListView>(R.id.binaryDishes) as ListView
        var utils = Utils()
        var adapter = activity?.let { BinaryAdapter(it,utils.populateDishesBinary(activity!!)) }
        listView.adapter = adapter
        return view
    }

}// Required empty public constructor
