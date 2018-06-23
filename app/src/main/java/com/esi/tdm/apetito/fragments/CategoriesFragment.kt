package com.esi.tdm.apetito.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ListView
import android.widget.Switch

import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.activities.DishInfoActivity
import com.esi.tdm.apetito.adapters.CategoriesAdapter
import com.esi.tdm.apetito.utlis.Utils


/**
 * A simple [Fragment] subclass.
 */
class CategoriesFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater!!.inflate(R.layout.fragment_categories, container, false)
        var listView = view.findViewById<ListView>(R.id.categoriesListView) as ListView
        var dayMenu = view.findViewById<View>(R.id.dayMenu) as FrameLayout
        var utils = Utils()
        var categoriesAdapter = activity?.let { CategoriesAdapter(it,utils.populateCategories(activity!!)) }
        listView.adapter = categoriesAdapter
        listView.setOnItemClickListener{adapterView,view,i,l ->

            when (i){
                0 -> activity!!.supportFragmentManager.beginTransaction()
                        .replace(R.id.mainFrame,EntriesFragmentFragment())
                        .commit()
                1 -> activity!!.supportFragmentManager.beginTransaction()
                        .replace(R.id.mainFrame,PrincipaleDishesFragment())
                        .commit()
                2 -> activity!!.supportFragmentManager.beginTransaction()
                        .replace(R.id.mainFrame,DrinksFragment())
                        .commit()
                3 -> activity!!.supportFragmentManager.beginTransaction()
                        .replace(R.id.mainFrame,DessertsFragment())
                        .commit()
                4 -> activity!!.supportFragmentManager.beginTransaction()
                        .replace(R.id.mainFrame,VegetarianFragment())
                        .commit()
                5 -> activity!!.supportFragmentManager.beginTransaction()
                        .replace(R.id.mainFrame,DiabiticFragment())
                        .commit()

            }
        }

        dayMenu.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity , DishInfoActivity::class.java)
            intent.putExtra("position",-1)
            startActivity(intent)
        })
        return view
    }

}// Required empty public constructor
