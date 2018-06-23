package com.esi.tdm.apetito.fragments


import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.esi.tdm.apetito.Entity.Category

import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.activities.DishInfoActivity
import com.esi.tdm.apetito.Adapter.DishAdapter
import com.esi.tdm.apetito.Adapter.RestaurantAdapter
import com.esi.tdm.apetito.models.Dish
import com.esi.tdm.apetito.utlis.Utils
import example.android.com.dataserverpersistance.viewmodel.DishViewModel
import example.android.com.dataserverpersistance.viewmodel.RestaurantViewModel
import kotlinx.android.synthetic.main.fragment_dish_infos.*
import org.jetbrains.anko.support.v4.intentFor


@SuppressLint("ValidFragment")
class CategoryDishesFragment(_category : Category) : Fragment() {

    var category : Category = _category

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view =  inflater!!.inflate(R.layout.fragment_category_dishes, container, false)
        var listView = view.findViewById<ListView>(R.id.dishesList) as ListView
        var utils = Utils()
        val dishViewModel = ViewModelProviders.of(this).get(DishViewModel::class.java)
        if (dishViewModel.dishes==null) {
            this!!.activity?.let {dishViewModel.loadData(it,listView) }
        }
        else {
            listView.adapter = this!!.activity?.let { DishAdapter(it, dishViewModel.dishes!!) }
        }

        listView.setOnItemClickListener{adapterView,view,i,l ->
            val dish = (adapterView.getItemAtPosition(i) as Dish)
            if (isTwoPan()){
                this!!.activity?.let { displayDetail(it,i) }
            }
            else{

                val intent = Intent(activity , DishInfoActivity::class.java)
                intent.putExtra("dish",dish)
                startActivity(intent)
            }
        }
        return view
    }

    fun isTwoPan() = activity?.findViewById<View>(R.id.fragment8) !=null
    fun displayDetail(_ctx: Context, i:Int){
//        var list = mutableListOf<Dish>()
//        var utils = Utils()
//        list = utils.populateDishesEntries(_ctx) as MutableList<Dish>
//        dishImage.setImageResource(list.get(i).listImage)
//        dishPriceDetail.setText(list.get(i).price.toString())
//        dishNameDetail.setText(list.get(i).name)
//        dishDescription.setText(list.get(i).description)
    }

}// Required empty public constructor
