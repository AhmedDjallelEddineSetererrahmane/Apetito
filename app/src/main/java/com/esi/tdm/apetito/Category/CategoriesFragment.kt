package com.esi.tdm.apetito.Category


import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ListView
import com.esi.tdm.apetito.Entity.Category

import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.Dish.DishInfoActivity
import com.esi.tdm.apetito.utlis.Utils
import example.android.com.dataserverpersistance.viewmodel.CategoryViewModel


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
        val categoryModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)

        if (categoryModel.categories==null) {
            this!!.activity?.let { categoryModel.loadData(it,listView) }
        }
        else {

            var categoriesAdapter = activity?.let { CategoryAdpater(it, categoryModel.categories!!) }
            listView.adapter = categoriesAdapter
        }

        listView.setOnItemClickListener{adapterView,view,i,l ->
            val category = (adapterView.getItemAtPosition(i) as Category)
            activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.mainFrame, CategoryDishesFragment(category))
                    .commit()

//            when (i){
//                0 -> activity!!.supportFragmentManager.beginTransaction()
//                        .replace(R.id.mainFrame, EntriesFragmentFragment())
//                        .commit()
//                1 -> activity!!.supportFragmentManager.beginTransaction()
//                        .replace(R.id.mainFrame, PrincipaleDishesFragment())
//                        .commit()
//                2 -> activity!!.supportFragmentManager.beginTransaction()
//                        .replace(R.id.mainFrame, DessertsFragment())
//                        .commit()
//                3 -> activity!!.supportFragmentManager.beginTransaction()
//                        .replace(R.id.mainFrame, DrinksFragment())
//                        .commit()
//                4 -> activity!!.supportFragmentManager.beginTransaction()
//                        .replace(R.id.mainFrame, VegetarianFragment())
//                        .commit()
//                5 -> activity!!.supportFragmentManager.beginTransaction()
//                        .replace(R.id.mainFrame, DiabiticFragment())
//                        .commit()
//
//            }
        }

        dayMenu.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity , DishInfoActivity::class.java)
            intent.putExtra("position",-1)
            startActivity(intent)
        })
        return view
    }

}// Required empty public constructor
