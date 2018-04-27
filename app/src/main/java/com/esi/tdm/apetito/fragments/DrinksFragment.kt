package com.esi.tdm.apetito.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView

import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.activities.DishInfoActivity
import com.esi.tdm.apetito.adapters.DishesAdapter
import com.esi.tdm.apetito.utlis.Utils


/**
 * A simple [Fragment] subclass.
 */
class DrinksFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view =  inflater!!.inflate(R.layout.fragment_drinks, container, false)
        var listView = view.findViewById<ListView>(R.id.drinks) as ListView
        var utils = Utils()
        var adapter = activity?.let { DishesAdapter(it,utils.populateDishes(8)) }
        listView.adapter = adapter

        listView.setOnItemClickListener{adapterView,view,i,l ->

            val intent = Intent(activity , DishInfoActivity::class.java)
            intent.putExtra("index",i)
            startActivity(intent)        }
        return view
    }

}// Required empty public constructor
