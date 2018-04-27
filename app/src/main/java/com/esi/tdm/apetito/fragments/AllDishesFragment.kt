package com.esi.tdm.apetito.fragments


import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView

import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.activities.RestaurantActivity
import com.esi.tdm.apetito.adapters.DishesAdapter
import com.esi.tdm.apetito.utlis.Utils
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.support.v4.act


/**
 * A simple [Fragment] subclass.
 */
class AllDishesFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater!!.inflate(R.layout.fragment_all_dishes, container, false)
        var listView = view.findViewById<ListView>(R.id.allDishes) as ListView
        var utils = Utils()
        var adapter = DishesAdapter(activity,utils.populateDishes(8))
        listView.adapter = adapter

        listView.setOnItemClickListener{adapterView,view,i,l ->

            activity.supportFragmentManager.beginTransaction()
                    .replace(R.id.mainFrame,DishInfosFragment())
                    .commit()
        }
        return view
    }

}// Required empty public constructor
