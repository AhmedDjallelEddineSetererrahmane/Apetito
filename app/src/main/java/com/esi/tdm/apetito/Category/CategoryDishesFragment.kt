package com.esi.tdm.apetito.Category


import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.esi.tdm.apetito.Entity.Category

import com.esi.tdm.apetito.R
import com.esi.tdm.apetito.Dish.DishInfoActivity
import com.esi.tdm.apetito.Adapter.DishAdapter
import com.esi.tdm.apetito.Entity.Dish
import com.esi.tdm.apetito.utlis.Utils
import example.android.com.dataserverpersistance.viewmodel.DishViewModel
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.support.v4.toast


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
                this.toast(dish.name)
                startActivity(activity!!.intentFor<DishInfoActivity>("dish" to dish ,"category" to category))
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
